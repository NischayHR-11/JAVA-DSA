package Stack.StackApplications.InfixTOPostfixExpression;
import java.util.Scanner;

class stack{

    int top;
    int size;
    char a[];

    stack(int size){

        this.size=size;
        top=-1;
        a=new char[size];
    }

    void push(char val){

        if(top==size-1){

            System.out.println("STACK IS FULL !! OVERFLOW");
            return;
        }

        a[++top]=val;

    }

    char pop(){

        if(top<0){

            System.out.println("STACK IS EMPTY !! UNDERFLOW");
            return ' ';
        }

        return a[top--];
    }

    char peek(){

        if(top<0){

            System.out.println("STACK IS EMPTY !! UNDERFLOW");
            return ' ';
        }


        return a[top];

    }

    int precedency(char s){

        if(s=='^' || s=='$')
        return 3;

        if(s=='%'||s=='*'||s=='/')
        return 2;

        if(s=='+'||s=='-')
        return 1;

        return 0;
    }

    char associativity(char s){

        if(s=='^'||s=='$')
        return 'R';

        else
        return 'L';
    }

    void InfixTOPost(stack s,String infix){

        String postfix="";

        for(int i=0;i<infix.length();i++){

            if((infix.charAt(i)>='a' && infix.charAt(i)<='z')&&(infix.charAt(i)>='A' && infix.charAt(i)<='Z')&&(infix.charAt(i)>='0' && infix.charAt(i)<='9')){

                postfix=postfix+infix.charAt(i);

            }else if(infix.charAt(i)=='('){

                s.push(infix.charAt(i));

            }else if(infix.charAt(i)==')'){

                while(s.top>=0 && s.peek()!='('){

                    postfix=postfix+s.pop();
                }

                s.top--;
            }else{

                while(s.top>=0 && precedency(infix.charAt(i))<=precedency(s.peek()) && associativity(infix.charAt(i))=='L'){

                    postfix=postfix+s.pop();
                }

                s.push(infix.charAt(i));
            }
        }

        while(s.top>=0){

            postfix=postfix+s.pop();
        }

        System.out.println("POSTFIX EXPRESSION : "+postfix);

    }


}

public class InfixTOPostfixExpression {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        stack s = new stack(50);
        stack s1=new stack(30);

        System.out.println("ENTER INFIX EXORESSION : ");
        String s2=sc.nextLine();
        s.InfixTOPost(s1, s2);
        
    }
    
}
