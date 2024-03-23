package Stack.StackApplications.InfixTOPrefixExpression;

import java.util.Scanner;

class stack{

    private int top=-1;
    private int size;
    private char a[];

    public stack(int size){

        this.size=size;
        a=new char [size];
    }

    public void push(char val){

        if(top==size-1){
            System.out.println("NOT POSSIBLE ");
            return;
        }

        a[++top]=val;

    }

    public char pop(){

        if(top<0){
            System.out.println("not possible");
            return ' ';
        }

        return a[top--];
    }

    public char peek(){

        if(top<0){
            System.out.println("not possible");
            return ' ';
        }

        return a[top];

    }

    public void displayStack(){

        for(int i=top;i>=0;i--){
            System.out.println(a[i]);
        }
    }

    private int precedency(char s){

        if(s=='^')
        return 3;

        if(s=='*'||s=='/'||s=='%')
        return 2;

        if(s=='+'||s=='-')
        return 1;

        return 0;
    }

    public String InfixToPre(String s2,stack s1){

        String Pre ="";

        String s="";

        for(int i=s2.length()-1;i>=0;i--){
            s=s+s2.charAt(i);
        }

        for(int i=0;i<s.length();i++){

            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                Pre=Pre+s.charAt(i);
            }else if(s.charAt(i)=='('){
                s1.push(s.charAt(i));
            }else if(s.charAt(i)==')'){

                while(s1.top>=0 && s1.peek()!='('){
                    Pre=Pre+s1.pop();
                }
                s1.top--;
            }else{

                while(s1.top>=0 && precedency(s.charAt(i))<precedency(s1.peek())){
                    Pre=Pre+s1.pop();
                }

                s1.push(s.charAt(i));
            }
        }

        while(s1.top>=0){
            Pre=Pre+s1.pop();
        }

        s="";

        for(int i=Pre.length()-1;i>=0;i--){
            s=s+Pre.charAt(i);
        }


        System.out.println("PREFIX EXPRESSION :"+s);

        return s;
    }

    public int Evaluation(stack s,String Pre){

        int res=0;

        for(int i=Pre.length()-1;i>=0;i--){

        if(Pre.charAt(i)>='0'&&Pre.charAt(i)<='9'){
            s.push((char) (Pre.charAt(i)-'0'));

        }else{

            int op1=s.pop();
            int op2=s.pop();

            switch (Pre.charAt(i)) {

                case '^':

                    res=op1^op2;
                    s.push(((char)res));
                    break;

                case '/':

                    res=op1/op2;
                    s.push(((char)res));
                    break;

                case '*':

                    res=op1*op2;
                    s.push(((char)res));
                    break;

                case '%':

                    res=op1%op2;
                    s.push(((char)res));
                    break;

                case '+':

                    res=op1+op2;
                    s.push(((char)res));
                    break;

                case '-':

                    res=op1-op2;
                    s.push(((char)res));
                    break;

            }

        }
    }

    res=(int)s.pop();

    return res;
    }


}

public class InfixTOPrefixExpression {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        stack s1=new stack(3);
        stack s2=new stack(3);

        System.out.println("ENTER THE EXPRESSION :");
        String s3=sc.nextLine();
        String prefix=s1.InfixToPre(s3, s1);
        System.out.println("EVALUATED VALUE : "+s1.Evaluation(s2, prefix));
        
    }
    
}
