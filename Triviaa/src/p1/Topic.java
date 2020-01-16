package p1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Topic {
	
	String question;
	ArrayList<String> options = new ArrayList<>();
	String answer;

	//Using array list to display Question.Option and answer
	public Topic(String question, ArrayList<String> options, String answer) {
		super();
		this.question = question;
		this.options = options;
		this.answer = answer;
	}
	
	public Topic() {
	}

	//Getters and setters
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	
	public ArrayList<Topic> getQuestions(String type) throws IOException {
		Scanner input = new Scanner(System.in);
		ArrayList<Topic> allQuestions = new ArrayList<>();
		BufferedReader fileReader;
		String line;
		
		if(type == "gk") {
			 fileReader = new BufferedReader(new FileReader("./temp/gk.txt"));
		}else if(type == "sp") {
			 fileReader = new BufferedReader(new FileReader("./temp/sp.txt"));
		}else{
			 fileReader = new BufferedReader(new FileReader("./temp/mov.txt"));
		}
		
		//Split Player Information From file using string and indexes
        while ((line = fileReader.readLine()) != null) {
        	String[] gk =  line.split(Pattern.quote(","));
        	String question;
        	ArrayList<String> options = new ArrayList<>();
        	String answer;
        
        	question = gk[0];
        	options.add(gk[1]);
        	options.add(gk[2]);
        	options.add(gk[3]);
        	options.add(gk[4]);
        	answer = gk[5];
        	
        	allQuestions.add(new Topic(question,options,answer));
        }
        return allQuestions;
	}
	
	//creating temp string to show question and Options
	public String toString() {
		String tempString = "";
		tempString += this.question + "\n";
		
		int count = 1;
		for(String option : this.options) {
			tempString += count + ". " +  option + "\n";
			count++;
		}	
		return tempString;
	}
}
