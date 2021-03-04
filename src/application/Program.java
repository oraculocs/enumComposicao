package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entity.Departamento;
import entity.HourContract;
import entity.Worker;
import enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		/*
		 * Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar
		 * do usuário um mês e mostrar qual foi o salário do funcionário nesse mês.
		 */

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		
		System.out.println("Nome trabalhador: ");
		String nome = sc.nextLine();
		
		System.out.println("Nível do Trabalhador");
		String nivel = sc.nextLine();
		
		System.out.println("Salário Base do Trabalhador: ");
		Double salario = sc.nextDouble();
		
		Worker worker = new Worker(nome, WorkerLevel.valueOf(nivel), salario, new Departamento(nomeDepartamento));
		
		System.out.println("Quantos contratos esse trabalhador tem?");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Entre com a Data (DD/MM/YYYY):");
			Date dataContrato = sdf.parse(sc.next());
			System.out.println("Valor por Hora: ");
			double valorHora = sc.nextDouble();
			System.out.println("Duração do Contrato: ");
			int hora = sc.nextInt();
			
			HourContract contract = new HourContract(dataContrato, valorHora, hora);
			
			worker.addContract(contract);
			
			
		}
		
		System.out.println();
		System.out.println("Entre com o mês e o ano para calcular o salário (MM/YYYY)");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " + worker.getNome());
		System.out.println("Departamento: " + worker.getDepartment().getNome());
		System.out.println("Renda para: " + mesAno + ": " + String.format("%.2f", worker.income(ano, mes)));
		
		sc.close();
	}

}
