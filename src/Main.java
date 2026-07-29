import java.io.FileReader;
class Main{
    public static void main(String[] args){
        try {
            FileReader reader = new FileReader("C:\\Users\\Nahila Afrin K\\IdeaProjects\\My New project\\src\\sample.txt");
            int data;
            while ((data = reader.read() )!= -1) {
                System.out.println((char) data);
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println("Error Occured");
        }
    }
}