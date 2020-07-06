
import java.io.IOException;
import java.util.*;
class Entry{
    String first_name,last_name,city;
    int age;
    public Entry(String fn,String ln, int a,String c){
        first_name=fn;
        last_name=ln;
        city=c;
        age=a;
    }
    @Override
    public String toString() {
    	return first_name+" "+last_name+" "+age+" "+city;
    }
}

class Database{
	public static void main(String args[])throws IOException {
     Scanner sc=new Scanner(System.in);
     ArrayList<Entry> data=new ArrayList<Entry>();
     do{
     System.out.println("Enter name:");
     String s=sc.nextLine();
     System.out.println("Enter age");
     int a=sc.nextInt();
     System.out.println("Enter city:");
     String c=sc.next();
     String s1[]=s.split(" ");
     data.add(new Entry(s1[0],s1[1],a,c));
     System.out.println("Do you want to add more (Y/N)");
     char ch=sc.next().charAt(0);
     if(ch=='N')break;
     sc.nextLine();
    }while(true);  
    for(Entry e: data)
    System.out.println(e);
    System.out.println("\nSort By?");
    System.out.println("1. First Name\n2. Second Name\n3.Age\n4.City");
    System.out.println("Enter your choice:");
    int choice=sc.nextInt();
    sc.close();
    switch(choice){
        case 1: Collections.sort(data,new SortByFirstName());
        break;
        case 2: Collections.sort(data,new SortByLastName());
        break;
        case 3: Collections.sort(data,new SortByAge());
        break;
        case 4: Collections.sort(data,new SortByCity());
        break;
        
    }
    for(Entry e: data)
    System.out.println(e);
 }
}
class SortByFirstName implements Comparator<Entry>{
	@Override
	public int compare(Entry first, Entry second){
		return first.first_name.compareTo(second.first_name);
	}
}
class SortByLastName implements Comparator<Entry>{
	@Override
	public int compare(Entry first, Entry second){
		return first.last_name.compareTo(second.last_name);
	}
}
class SortByAge implements Comparator<Entry>{
	@Override
	public int compare(Entry first, Entry second){
		return first.age-second.age;
	}
}
class SortByCity implements Comparator<Entry>{
	@Override
	public int compare(Entry first, Entry second){
		return first.city.compareTo(second.city);
	}
}

