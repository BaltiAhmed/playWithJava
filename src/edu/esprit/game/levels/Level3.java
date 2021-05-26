package edu.esprit.game.levels;

import edu.esprit.game.models.Employee;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import edu.esprit.game.utils.Data;
import java.util.Map;
import java.util.stream.Collectors;
import static jdk.nashorn.internal.objects.NativeArray.map;

public class Level3 {

    public static void main(String[] args) {
        List<Employee> employees = Data.employees();


        /* TO DO 1: Retourner une chaine de caract�re qui contient tous les noms des employ�s */
        String names = employees.stream().map((e) -> e.getName()).reduce("", (a, b) -> a + " " + b);
        System.out.println(names);
        int salair = employees.stream().mapToInt((e) -> e.getSalary()).reduce(0, (a, b) -> a + b);
        System.out.println("salaire :" + salair);
//	/* TO DO 2: Retourner une chaine de caract�re qui contient tous les noms des employ�s en majuscule separ�s par # */	
        String namesMajSplit = employees.stream().map(e -> e.getName().toUpperCase()).reduce("", (a, b) -> a + "#" + b);
        System.out.println(namesMajSplit);
//
//	/* TO DO 3: Retourner une set d'employ�s*/
	Set<Employee> emps = employees.stream().collect(Collectors.toSet());
//
//	/* TO DO 4: Retourner une TreeSet d'employ�s (tri par nom) */
	TreeSet<Employee> emps2 = employees.stream().collect(Collectors.toCollection(()->new TreeSet<>()));//comparable
TreeSet<Employee> emps3 = employees.stream().
        collect(Collectors.toCollection(()->new TreeSet<>((a,b)->a.getName().compareTo(b.getName()))));
//	/* TO DO 5: Retourner une Map qui regroupe les employ�s par salaire */
	Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy((e)->e.getSalary()));
        
        map.forEach((e,v)->{
            System.out.println("e"+e);
            System.out.println("v"+v);
        });
        map.keySet().stream().forEach((e)->System.out.println(e));
        
         map.values().stream().forEach((e)->System.out.println(e));
//			
//	/* TO DO 6: Retourner une Map qui regroupe les nom des employ�s par salaire */
	Map<Integer, String> mm = employees.stream().
                collect(Collectors.toMap((e)->e.getSalary(),Employee::getName,(a,b)->a+" "+b));
        System.out.println(mm);
//
//	/* TO DO 7: Retourner le  min, max,average, sum,count des salaires */
	String s = employees.stream().mapToDouble((e)->e.getSalary()).summaryStatistics().toString();
        System.out.println(s);
//				

    }
}
