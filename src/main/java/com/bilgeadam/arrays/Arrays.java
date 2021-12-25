package com.bilgeadam.arrays;

public class Arrays {

    //virgül (,) ile aynı tipte birden fazla değişken tanımlanabilir.
    //array : diziliş, sıraya dizmek vb.
    //her veri tipinde array oluşturulabilir.
    //köşeli parantez

    char one = 'M', two = 'U', three = 'H', four = 'A', five = 'M', six = 'M', seven = 'E', eight = 'T';

    String name = "MUHAMMET";
    
    char [] letters;
    
    public static void main (String [] args) {
        
        Arrays vars = new Arrays();

        System.out.println("vars.one + vars.two + vars.three + vars.four + vars.five + vars.six + vars.seven + vars.eight = " + vars.one + vars.two + vars.three + vars.four + vars.five + vars.six + vars.seven + vars.eight);

        System.out.println("My name is " + vars.name);
        
        vars.letters = new char[8]; //"bu char 8 eleman alabilir"
        System.out.println("vars.letters[0] = " + vars.letters[0]); //değer henüz atanmadığı için ASCII tipinde 000 (null) default değeri verir.
        
        vars.letters[0] = vars.one; //index "0" ile başlar. ilk karakterin indexi "0"dır.
        vars.letters[1] = vars.two;
        vars.letters[2] = vars.three;
        vars.letters[3] = vars.four;
        vars.letters[4] = vars.five;
        vars.letters[5] = vars.six;
        vars.letters[6] = vars.seven;
        vars.letters[7] = vars.eight;


        for (int i = 0; i < vars.letters.length; i++) {
            System.out.println("vars.letters : " + vars.letters[i]);
        }

        char [] secondArray = vars.name.toCharArray();

        for (int i = 0; i < secondArray.length; i++) {
            System.out.println("secondArray = " + secondArray[i]);
        }

        vars.letters[4] = 'G'; //belirtilen (4) index değerini yeni verilen değer ile değiştirir.
        for (int i = 0; i < vars.letters.length; i++) {
            System.out.println("vars.letters = " + vars.letters[i]);
        }


        //2 boyutlu array
        //birden fazla saklanacak değerler. (örneğin; satranç tahtası için, siyah ve beyaz kareler)
        //tüm boyutlar aynı veri tipinde olmalı.

        char [][] board = new char [5][4];

        //int [][][][] time = new int [24][60][60][1000] (saat,dakika,saniye,milisanye)

        board[0][0] = 'W';
        board[0][2] = 'B';
        board[1][3] = 'W';
        board[3][2] = 'B';
        board[4][2] = 'B';
        board[2][0] = 'B';

        for (int i = 0; i < board.length; i++) {              //board'ın uzunluğu 5'tir
            for (int j = 0; j < board[i].length; j++) {       //board[i]'nin uzunluğu 4'tür.
                System.out.print(board[i][j] + "   ");

            }
            System.out.println();
        }

        //ÖRNEK; 5 eyalette 3 okul var. her okulda 12 sınıf var. öğrenci sayılarını alıyoruz.
        //int [][][] studentCount = new int [][][]
        //yukarıdaki gibi "primitive type" şekilde de yazılabilir.
        //aşağıdaki gibi "referrence type" şekilde de yazılabilir.
        //iki durumda da; değişken tanımlanmaz ise default değer döndürür. (referrence için 'null')
        //değer girilmeyen array'lerin tespiti için referrence kullanılabilir.
        //değer girilmeyen array'ler önemsiz ise primitive kullanılabilir.

        Byte [][][] studentCount = new Byte [5][3][12];

        studentCount[0][2][4] = 18;
        studentCount[0][1][10] = 12;
        studentCount[1][0][9] = 23;
        studentCount[3][1][8] = 42;
        studentCount[4][0][11] = 17;
        studentCount[0][1][4] = 10;
        studentCount[2][2][3] = 21;
        studentCount[2][1][7] = 16;
        studentCount[4][2][1] = 6;

        for (int i = 0; i < studentCount.length; i++) {
            for (int j = 0; j < studentCount[i].length; j++) {
                for (int k = 0; k < studentCount[i][j].length; k++) {
                    System.out.println(("[" +i+ "]" + "[" +j+ "]" + "[" +k+ "]") + studentCount[i][j][k]);

                }

            }

        }


    }
    
}