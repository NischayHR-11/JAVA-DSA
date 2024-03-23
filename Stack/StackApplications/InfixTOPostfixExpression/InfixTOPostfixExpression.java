package Stack.StackApplications.InfixTOPostfixExpression;
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

    private char associativity(char s){

        if(s=='^')
        return 'R';

        return 'L';
    }

    public String InfixToPost(String s,stack s1){

        String post="";

        for(int i=0;i<s.length();i++){

            if((s.charAt(i)>='a'&&s.charAt(i)<='z')||(s.charAt(i)>='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                post=post+s.charAt(i);
            }else if(s.charAt(i)=='('){
                s1.push(s.charAt(i));
            }else if(s.charAt(i)==')'){

                while(s1.top>=0 && s1.peek()!='('){
                    post=post+s1.pop();
                }
                s1.top--;
            }else{

                while(s1.top>=0 && precedency(s.charAt(i))<=precedency(s1.peek()) && associativity(s.charAt(i))=='L'){
                    post=post+s1.pop();
                }

                s1.push(s.charAt(i));
            }
        }

        while(s1.top>=0){
            post=post+s1.pop();
        }

        System.out.println("POSTFIX EXPRESSION :"+post);

        return post;
    }

    public int Evaluation(stack s,String post){

        int res=0;

        for(int i=0;i<post.length();i++){

        if(post.charAt(i)>='0'&&post.charAt(i)<='9'){
            s.push((char) (post.charAt(i)-'0'));

        }else{

            int op2=s.pop();
            int op1=s.pop();

            switch (post.charAt(i)) {

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

class InfixTOPostfixExpression{

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        stack s1=new stack(3);
        stack s2=new stack(3);

        System.out.println("ENTER THE EXPRESSION :");
        String s3=sc.nextLine();
        String postfix=s1.InfixToPost(s3, s1);
        System.out.println("EVALUATED VALUE : "+s1.Evaluation(s2, postfix));


    }

}
