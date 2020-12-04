package TransMatrix;
import java.io.*;
import java.util.ArrayList;
public class Read {
    public void Matrix(String pathToGFile) throws IOException{
        FileInputStream fread = null;
        fread =new FileInputStream(pathToGFile);
        BufferedInputStream bf = new BufferedInputStream(fread);
        int c = 0;

        ArrayList<Character> temp = new ArrayList<>();

        int sizei =0, sizej = 0, Maxsizej = 0;
        Maxsizej = Integer.MIN_VALUE;
        bf.mark(0);// Ставим метку на 0, чтобы потом вернуться
        while ((c = bf.read()) != -1){//Определяем размер массива
            if(c == 13){sizei++; if(sizej> Maxsizej){
            Maxsizej = sizej;} sizej = 0;}
            if(c == 32) sizej++;}
        sizej = Maxsizej;
        bf.reset();// Сбрасываем поток

        int[][] temparr = new int[sizei+1][sizej+1];
        int i =0,j =0;
        int count =0;
        int TotalBytes = bf.available();
        while ((c = bf.read())!=-1){
            count++;
            if(c!= 13&& c!=10&& c!= 32){
                temp.add((char)c);
            }
            if(c == 13)
            {
                String str = "";
                for (int k =0; k< temp.size(); k++){
                    str+=temp.get(k);
                }
                temparr[i][j] = Integer.parseInt(str);
                temp.clear();
                i++;
                j=0;
            }
            if(c == 32) {
                String str ="";
                for (int k =0; k< temp.size(); k++){
                    str+= temp.get(k);
                }
                temparr[i][j] = Integer.parseInt(str);
                j++;
                temp.clear();
            }
            if(TotalBytes == count)
            {
                String str = "";
                for (int k=0; k< temp.size(); k++){
                    str+= temp.get(k);
                }
                temparr[i][j] = Integer.parseInt(str);
                j++;
                temp.clear();
            }
        }
        //Выводим матрицу на экран
        System.out.println("Изначальная матрица:");
        for (i =0;i< temparr.length;i++){
            for (j =0; j<temparr[i].length; j++){
                System.out.print(temparr[i][j]+" ");
            }
            System.out.println();
        }
        //Выводим содержимое транспонированной матрицы на экран
        System.out.println("Транспонированная матрица:");
        for (i =0;i< temparr.length;i++){
            for (j =0; j<temparr[i].length; j++){
                System.out.print(temparr[j][i]+" ");
            }
            System.out.println();
        }
    }
}
