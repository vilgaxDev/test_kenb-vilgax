package com.bank.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bank.dto.TransferDTO;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.entity.LoanAccount;
import com.bank.entity.LoanTransactions;
import com.bank.entity.PersonalLoan;
import com.bank.entity.Transactions;
import com.bank.repo.AccountRepo;
import com.bank.repo.CustomerRepo;
import com.bank.repo.LoanAccountRepo;
import com.bank.repo.TransactionsRepo;

/**
 * @author Kenb.vilgax
 *
 */

/*This Controller handles all the requests related to this overall application.*/
@Controller
public class CustomerController {

	@Autowired
	private CustomerRepo custRepo;

	@Autowired
	private AccountRepo accountRepo;

	@Autowired
	private LoanAccountRepo loanAccountRepo;

	@SuppressWarnings("unused")
	@Autowired
	private TransactionsRepo transactionsRepo;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	Transactions closingTransaction;

	@Autowired
	Customer globalCustomer;

	@Autowired
	HttpSession session;

	@Autowired
	LoanAccount loanAccount;

	private double interestRate = 11.0;

	DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	Date currentDate = new Date();
	private List<Transactions> transList = new ArrayList<Transactions>();
	private List<LoanTransactions> loanTransList = new ArrayList<LoanTransactions>();

	/*This API opens the home page*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String openHomePage() {
		return "home";
	}
	
	/*This API opens the registration page*/
	@RequestMapping(value = "/registerOpener", method = RequestMethod.GET)
	public String registerOpener(Model model) {
		model.addAttribute("registrationForm", new Customer());
		return "registration";

	}

	/*This API takes the Customer object as input from JSP page and save to database.*/
	@RequestMapping("/registerCustomer")
	public String saveCustomer(Model model, @ModelAttribute("registrationForm") Customer cust,
			RedirectAttributes redirectAttributes) {
		if (cust.getCid() == null) {
			Customer c = custRepo.findByEmail(cust.getEmail());
			if (c == null) {
				Account account = new Account();
				account.setAccountNo(generateAccount());
				cust.setAccount(account);
				account.setCustomer(cust);
				custRepo.save(cust);
			} else {
				redirectAttributes.addFlashAttribute("error", "Email ID is registered with another user!");
				return "redirect:registerOpener";
			}
		} else if (cust.getCid() != null) {
			custRepo.save(cust);
			return "redirect:/openDashbord";
		}
		return "/home";
	}

	/*This API is used to update the Customer information. It takes id and Customer object as input.*/
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.GET)
	public String editStudent(Model model, @RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
		Customer cust = custRepo.getOne(id);
		model.addAttribute("registrationForm", cust);
		model.addAttribute("customer", cust);
		redirectAttributes.addFlashAttribute("success", "Record added successfully!!!");
		redirectAttributes.addFlashAttribute("error", "Ooops! Something went wrong!");
		return "registration";

	}

	/*This API is used to delete the Customer object from database.It takes ID as input.*/
	@RequestMapping(value = "/deleteStudent")
	public String deleteStudent(Model model, @RequestParam("id") Integer id) {
		Customer s = custRepo.getOne(id);
		custRepo.delete(s);
		return "redirect:/";
	}

	/*This API opens the login page*/
	@RequestMapping(value = "/loginOpener", method = RequestMethod.GET)
	public String loginPageOpener(Model model) {
		model.addAttribute("loginForm", new Customer());
		
		return "login";
	}

	
	/*This API takes Username and password as input and it is valid Customer or not.*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("loginForm") Customer customer,
			RedirectAttributes redirectAttributes) {

		Customer cust = custRepo.findByEmail(customer.getEmail());
		if (cust != null) {

			if (customer.getEmail().equals(cust.getEmail())
					&& customer.getPassword().contentEquals(cust.getPassword())) {
				model.addAttribute("customer", cust);
				globalCustomer = cust;
				session.setAttribute("loginCustomer", cust);
				return "dashboard";
			} else {
				redirectAttributes.addFlashAttribute("error", "Wrong Username or password!");

				return "redirect:/loginOpener";
			}
		} else {
			redirectAttributes.addFlashAttribute("loginerror", "Account does not exist!");
			return "redirect:/loginOpener";
		}

	}

	/*This API displays all branches of the bank.*/
	@RequestMapping("/viewBranches")
	public String viewBranches() {
		return "viewBranches";
	}

	/*This API opens the deposit page*/
	@RequestMapping("/depositeOpener")
	public String depositeAmmount(Model model) {
		model.addAttribute("depositeForm", new Transactions());
		return "deposite";

	}

	/*This API opens the withdraw page*/
	@RequestMapping("/withdrawOpener")
	public String withdrawAmmount(Model model) {
		model.addAttribute("withdrawForm", new Transactions());
		return "withdraw";

	}

	/*This API opens the forget password page*/
	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.GET)
	public String passwordResetOpener(Model model) {

		model.addAttribute("passwordResetForm", new Customer());
		return "passwordResetForm";

	}

	/*This API resets the Customer password.It takes Customer object as input.*/
	@RequestMapping(value = "/resetPassword")
	public String resetPassword(Model model, @ModelAttribute("passwordResetForm") Customer customer) {
		custRepo.updatePassword(customer.getEmail(), customer.getPassword());
		return "redirect:loginOpener/";
	}

	/*This API used to deposit the given amount in Customer account. 
	 * It takes Transaction object as input. */
	@RequestMapping("/deposite")
	public String deposite(Model model, @ModelAttribute("depositeForm") Transactions transactions) {

		Customer customer = (Customer) session.getAttribute("loginCustomer");
		Account acc = custRepo.getAccountByCustomerCid(customer.getCid());
		Double cbalance = acc.getTotalBalance() + transactions.getAmmount();
		transactions.setTransactionType("DEPOSITE");
		transactions.setTransDate(df.format(currentDate));
		//transactions.setClosingBalance(acc.getTotalBalance()+transactions.getAmmount());
		transactions.setAccount(acc);
		transList.add(transactions);
		acc.setTransactionList(transList);
		acc.setTotalBalance(cbalance);
		accountRepo.save(acc);
		return "dashboard";
	}

	/*This API used to withdraw the given amount from customer account. 
	 * It takes Transaction object as input.Transaction object contains withdraw amount */
	@RequestMapping("withdraw")
	public String withdrawal(Model model, @ModelAttribute("depositeForm") Transactions transactions,RedirectAttributes redirectAttributes) {
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		Account acc = custRepo.getAccountByCustomerCid(customer.getCid());
		
		if(acc.getTotalBalance()>=transactions.getAmmount()) {
		Double cbalance = acc.getTotalBalance() - transactions.getAmmount();
		transactions.setTransactionType("WITHDRAW");
		transactions.setTransDate(df.format(currentDate));
		transactions.setAccount(acc);
		// transactions.setClosingBalance(cbalance);
		transList.add(transactions);
		acc.setTransactionList(transList);
		acc.setTotalBalance(cbalance);
		accountRepo.save(acc);
		return "dashboard";
		}
		else
		{
			redirectAttributes.addFlashAttribute("inSufficientBalance", "Sorry, Insufficient balance!");
			return "redirect:backToDashboard";
		}
	}

	/*This API opens the amount transfer page*/
	@RequestMapping("/transferOpener")
	public String transferOpener(Model model) {
		model.addAttribute("transferForm", new TransferDTO());
		return "transfer";

	}

	/*This API transfer the amount from Customer account to another customer account.
	 * It takes input Customer account number and amount to be transfer.*/
	@RequestMapping("transfer")
	public String transfer(Model model, @ModelAttribute("transferForm") TransferDTO transferDTO,
			RedirectAttributes redirectAttributes) {
		Customer customer = (Customer) session.getAttribute("loginCustomer");
		Account Myacc = custRepo.getAccountByCustomerCid(customer.getCid());
		Account useracc = accountRepo.getAccountByaccountNo(transferDTO.getAccountNo());
		if (Myacc.getTotalBalance() >= transferDTO.getAmount()) {
			useracc.setTotalBalance(useracc.getTotalBalance() + transferDTO.getAmount());

			Myacc.setTotalBalance(Myacc.getTotalBalance() - transferDTO.getAmount());

			Transactions transactions = new Transactions();
			transactions.setTransactionType("CREDITED FROM " + Myacc.getAccountNo());
			transactions.setTransDate(df.format(currentDate));
			transactions.setAmmount(transferDTO.getAmount());
			// transactions.setClosingBalance(useracc.getTotalBalance());
			transactions.setAccount(useracc);
			transList.add(transactions);
			useracc.setTransactionList(transList);
			accountRepo.save(useracc);

			Transactions trans = new Transactions();
			trans.setTransactionType("TRANSFERED TO " + useracc.getAccountNo());
			trans.setTransDate(df.format(currentDate));
			trans.setAmmount(transferDTO.getAmount());
			// transactions.setClosingBalance(Myacc.getTotalBalance());
			trans.setAccount(Myacc);
			Myacc.setTransactionList(transList);
			transList.add(trans);
			accountRepo.save(Myacc);

			return "dashboard";
		} else
			redirectAttributes.addFlashAttribute("error", "Insufficient balance !!!");
			return "redirect:transfer";
	}

	/*This API opens the my profile page*/
	@RequestMapping("/profileOpener")
	public String myProfile(Model model) {
		// Customer customer = (Customer) session.getAttribute("loginCustomer");
		Customer c = custRepo.findByEmail(globalCustomer.getEmail());
		model.addAttribute("customerInfo", c);
		return "myProfile";

	}

	/*This API opens dashboard page*/
	@RequestMapping("backToDashboard")
	public String backToDashboard() {
		return "dashboard";
	}

	/*This API opens the personal loan page*/
	@RequestMapping("personalOpener")
	public String personalLoanOpener(Model model) {
		model.addAttribute("personalLoanChecker", new PersonalLoan());
		return "personalLoan";
	}

	/*This API checks the loan eligibility and transfer the loan amount to Customer account if eligibility matches.*/
	@RequestMapping("personal")
	public String loanProvider(Model model, @ModelAttribute("personalLoanChecker") PersonalLoan personal,
			RedirectAttributes redirectAttributes) {
		LoanAccount la = loanAccountRepo.findByloanAccountId(globalCustomer.getCid());
		Account acc = custRepo.getAccountByCustomerCid(globalCustomer.getCid());
		if (la == null) {
			if (personal.getSalary() >= 30000 && personal.getSalary() <= 50000 && personal.getLoanAmount() > 100000
					&& personal.getLoanAmount() <= 400000) {
				loanAccount.setLoanAccountNumber(generateLoanAccount());
				double loanAmountWithInterest = personal.getLoanAmount() * personal.getLoanDuration() * 11 / 100;
				loanAccount.setLoanBalance(loanAmountWithInterest);

				loanAccount.setLoanDuration(personal.getLoanDuration());
				loanAccount.setInterestRate(interestRate);
				loanAccount.setLoanEMIRemaining(personal.getLoanDuration());

				double emi = Math.round(loanAmountWithInterest / personal.getLoanDuration());
				loanAccount.setLoanEMI(emi);
				loanAccount.setCustomer(globalCustomer);
				loanAccountRepo.save(loanAccount);

				Transactions transactions = new Transactions();
				Double cbalance = acc.getTotalBalance() + personal.getLoanAmount();

				transactions.setTransactionType("LOAN CREDITED FROM kenb BANK");
				transactions.setTransDate(df.format(currentDate));
				transactions.setAmmount(personal.getLoanAmount());

				transactions.setAccount(acc);

				transList.add(transactions);
				acc.setTransactionList(transList);

				acc.setTotalBalance(cbalance);
				accountRepo.save(acc);

				System.out.println("Congratulations! Your loan is approved.");

			} else if (personal.getSalary() > 50000 && personal.getSalary() <= 100000
					&& personal.getLoanAmount() > 400000 && personal.getLoanAmount() <= 600000) {
				loanAccount.setLoanAccountNumber(generateLoanAccount());
				double loanAmountWithInterest = personal.getLoanAmount() * personal.getLoanDuration() * 11 / 100;

				loanAccount.setLoanBalance(loanAmountWithInterest);

				loanAccount.setLoanDuration(personal.getLoanDuration());
				loanAccount.setInterestRate(interestRate);
				loanAccount.setLoanEMIRemaining(personal.getLoanDuration());

				double emi = Math.round(loanAmountWithInterest / personal.getLoanDuration());
				loanAccount.setLoanEMI(emi);
				loanAccount.setCustomer(globalCustomer);
				loanAccountRepo.save(loanAccount);
				Transactions transactions = new Transactions();
				Double cbalance = acc.getTotalBalance() + personal.getLoanAmount();

				transactions.setTransactionType("LOAN CREDITED FROM kenb BANK");
				transactions.setTransDate(df.format(currentDate));
				transactions.setAmmount(personal.getLoanAmount());

				transactions.setAccount(acc);

				transList.add(transactions);
				acc.setTransactionList(transList);

				acc.setTotalBalance(cbalance);
				accountRepo.save(acc);
				System.out.println("Congratulations! Your loan is approved.");

			} else if (personal.getSalary() > 100000 && personal.getLoanAmount() > 600000
					&& personal.getLoanAmount() < 1000000) {
				loanAccount.setLoanAccountNumber(generateLoanAccount());
				double loanAmountWithInterest = personal.getLoanAmount() * personal.getLoanDuration() * 11 / 100;

				loanAccount.setLoanBalance(loanAmountWithInterest);

				loanAccount.setLoanDuration(personal.getLoanDuration());
				loanAccount.setInterestRate(interestRate);
				loanAccount.setLoanEMIRemaining(personal.getLoanDuration());

				double emi = Math.round(loanAmountWithInterest / personal.getLoanDuration());
				loanAccount.setLoanEMI(emi);
				loanAccount.setCustomer(globalCustomer);
				loanAccountRepo.save(loanAccount);

				Transactions transactions = new Transactions();
				Double cbalance = acc.getTotalBalance() + personal.getLoanAmount();

				transactions.setTransactionType("LOAN CREDITED FROM kenb BANK");
				transactions.setTransDate(df.format(currentDate));
				transactions.setAmmount(personal.getLoanAmount());

				transactions.setAccount(acc);

				transList.add(transactions);
				acc.setTransactionList(transList);

				acc.setTotalBalance(cbalance);
				accountRepo.save(acc);
				System.out.println("Congratulations! Your loan is approved.");

			} else {
				redirectAttributes.addFlashAttribute("notApplicable", "Sorry! Your Salary is not applicable for loan.");
				return "redirect:backToDashboard";
			}
		}
		else {
			redirectAttributes.addFlashAttribute("allreadyLoan", "Sorry! You already have a loan.");
			return "redirect:backToDashboard";
		}

		return "dashboard";

	}

	/*This API opens the loan EMI pay page.
	 * It checks first Customer have a loan or not if yes then opens loan EMI page else return a message */
	@RequestMapping("LoanEmiOpener")
	public String payLoanEmiOpener(Model model, RedirectAttributes attributes) {
		LoanAccount la = loanAccountRepo.findByloanAccountId(globalCustomer.getCid());
		if (la != null) {
			model.addAttribute("loanEMIForm", new TransferDTO());
			return "payLoanEmi";
		}
		attributes.addFlashAttribute("loanNotAvailable", "Sorry! You dont have any loan.");
		return "redirect:backToDashboard";

	}

	/*This API is used to pay loan EMI amount.
	 * It takes loanEMI amount as input*/
	@RequestMapping("payPersonalEMI")
	public String payLoanEMI(Model model, @ModelAttribute("loanEMIForm") TransferDTO transferDTO,
			RedirectAttributes redirectAttributes) {
		Account ac = accountRepo.getOne(globalCustomer.getCid());
		LoanAccount la = loanAccountRepo.findByloanAccountId(globalCustomer.getCid());
		if (transferDTO.getLoanAccountNumber().equals(la.getLoanAccountNumber())) {
			if (transferDTO.getLoanEMI() == la.getLoanEMI()) {
				double oldLoanBalance = la.getLoanBalance();
				la.setLoanBalance(oldLoanBalance - transferDTO.getLoanEMI());
				la.setLoanEMIRemaining(la.getLoanEMIRemaining() - 1);

				ac.setTotalBalance(ac.getTotalBalance() - transferDTO.getLoanEMI());

				LoanTransactions loanTransactions = new LoanTransactions();
				loanTransactions.setEmi(transferDTO.getLoanEMI());
				loanTransactions.setTransactionType("LOAN EMI DEBITED FROM SAVING ACCOUNT " + ac.getAccountNo());
				loanTransactions.setTransDate(df.format(currentDate));
				loanTransactions.setLoanAccount(la);
				loanTransList.add(loanTransactions);

				la.setLoanTransactionList(loanTransList);

				Transactions transactions = new Transactions();

				transactions.setTransactionType("LOAN EMI DEBITED TOWARDS LOAN ACCOUNT " + la.getLoanAccountNumber());
				transactions.setTransDate(df.format(currentDate));
				transactions.setAmmount(transferDTO.getLoanEMI());

				transactions.setAccount(ac);

				transList.add(transactions);
				ac.setTransactionList(transList);

				accountRepo.save(ac);
				loanAccountRepo.save(la);
			} else {
				redirectAttributes.addFlashAttribute("amountError", "Amount is not matching to your EMI amount.");
				return "redirect:LoanEmiOpener";
			}
		} else {
			redirectAttributes.addFlashAttribute("accountError", "Incorrect account number!");
			return "redirect:LoanEmiOpener";
		}
		return "dashboard";
	}

	/*This API opens the loan eligibility page*/
	@RequestMapping("eligibility")
	public String eligibilityOpener(Model model) {

		return "eligibilityCheck";
	}

	/*This API opens the about us page*/
	@RequestMapping("aboutus")
	public String viewAboutUsPage(Model model) {
		return "aboutus";

	}
	
	/*This API opens the contact us page*/
	@RequestMapping("contactus")
	public String viewContactUsPage() {
		return "contactus";
	}

	/*This API shows the Mini-Statements by Customer ID.*/
	@RequestMapping("miniStatement")
	public String miniStatement(Model model) {

		// Customer customer = (Customer) session.getAttribute("loginCustomer");
		Account acc = custRepo.getAccountByCustomerCid(globalCustomer.getCid());
		model.addAttribute("accountInfo", acc);
		model.addAttribute("getAllTransactions", acc.getTransactionList());

		return "miniStatements";

	}
	
	/*This API shows all loan transactions of the login Customer.*/
	@RequestMapping("loanTransactions")
	public String showLoanTransactions(Model model, RedirectAttributes redirectAttributes) {
		LoanAccount loanAccount = loanAccountRepo.findByloanAccountId(globalCustomer.getCid());
		if(loanAccount!=null) {
		model.addAttribute("loanAccount", loanAccount);
		model.addAttribute("getLoanTransactions", loanAccount.getLoanTransactionList());
		return "loanTransactions";
		}
		redirectAttributes.addFlashAttribute("loanNotAvailable", "Sorry! You dont have any loan.");
		return "redirect:backToDashboard";

	}

	/*This API opens the dashboard of login Customer.*/
	@RequestMapping("/openDashbord")
	public String dashboardOpener() {
		return "dashboard";

	}
	
	/*This API shows the balance of login Customer.*/
	@RequestMapping("/viewBalance")
	public String viewBalance(Model model) {
		// Customer customer = (Customer) session.getAttribute("loginCustomer");
		Account acc = accountRepo.getOne(globalCustomer.getCid());
		model.addAttribute("AccountInfo", acc);
		return "viewBalance";
	}

	/*This method generate random account number for Customer.*/
	public String generateAccount() {
		Random r = new Random();

		return "YB" + r.nextInt();
	}

	/*This method generate random loan account number for Customer.*/
	public String generateLoanAccount() {
		Random r = new Random();

		return "LA" + r.nextInt();

	}
}
