package entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.WorkerLevel;

public class Worker {
	
	/*
	 * Classe de Entidade: Trabalhador
	 * Atributos e m�todos padr�o Java Bean
	 * Enum para informar qual o n�vel do Trabalhador
	 * Departamento que ele atua e ele pode estar associado
	 * a v�rios contratos
	 */
	
	private String nome;
	private WorkerLevel level;
	private Double salarioBase;
	
	//TEM UM Departamento
	private Departamento department;
	
	//Composi��o TEM MUITOS, n�o coloca ele no construtor, s� inicia a Lista Vazia
	private List<HourContract> contracts = new ArrayList<HourContract>();

	public Worker() {

	}

	public Worker(String nome, WorkerLevel level, Double salarioBase, Departamento department) {
		super();
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.department = department;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartment() {
		return department;
	}

	public void setDepartment(Departamento department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	//Esse m�todo vai pegar a Lista de contratos e vai adicionar esse contrato que veio como par�metro
	//2 m�todos respons�veis que fazem ou desfazem a associa��o entre um trabalhador e um contrato
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		//Para cada contrato c vou setar a data do Calend�rio do contrato c
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
