package entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enums.WorkerLevel;

public class Worker {
	
	/*
	 * Classe de Entidade: Trabalhador
	 * Atributos e métodos padrão Java Bean
	 * Enum para informar qual o nível do Trabalhador
	 * Departamento que ele atua e ele pode estar associado
	 * a vários contratos
	 */
	
	private String nome;
	private WorkerLevel level;
	private Double salarioBase;
	
	//TEM UM Departamento
	private Departamento department;
	
	//Composição TEM MUITOS, não coloca ele no construtor, só inicia a Lista Vazia
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
	
	//Esse método vai pegar a Lista de contratos e vai adicionar esse contrato que veio como parâmetro
	//2 métodos responsáveis que fazem ou desfazem a associação entre um trabalhador e um contrato
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		//Para cada contrato c vou setar a data do Calendário do contrato c
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
