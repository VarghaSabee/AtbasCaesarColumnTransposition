package pr1;

import java.util.Arrays;
import java.util.Scanner;

public class Transposition {

    private String tmp_matrix;

    public String getTmp_matrix() {
        return tmp_matrix;
    }

    private void setTmp_matrix(String tmp_matrix) {
        this.tmp_matrix = tmp_matrix;
    }

    /**
     *
     * @param msg Message
     * @param key Key
     * @param encrypt Boolean if is encryption
     * @return string of encrypted or decrypted message
     */
    public String encryptdecrypt(String msg, String key) {
        msg = msg.replaceAll("\\s", "").replaceAll("\n", "").toLowerCase();
        key = key.replaceAll("\\s", "").replaceAll("\n", "").toLowerCase();

        key = UniqueCharsKey("key");

        String crypted = "";

        char[] array_msg = msg.toCharArray();

        int keylen = key.length();
        int row_len = (int) Math.ceil(array_msg.length / keylen) + 1;

        char[][] tmp = new char[keylen][row_len];

        tmp = FillMatrix(tmp, array_msg, keylen);

        char[] tmp_key = key.toCharArray();
        Arrays.sort(tmp_key);

        setTmp_matrix("");
        for (int j = 0; j < row_len; j++) {
            for (int i = 0; i < keylen; i++) {
                int pos = 0;
                for (pos = 0; pos < tmp_key.length; pos++) {
                    if (key.charAt(i) == tmp_key[pos]) {
                        break;
                    }
                }
                tmp_matrix += tmp[pos][j] + " ";
                crypted += tmp[pos][j];
            }
            tmp_matrix += "\n";
//                crypted += " ";
        }

//        System.out.println(crypted);
        return crypted;
    }

    private void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private String UniqueCharsKey(String key) {
        char[] array = key.toCharArray();
        String _array = "";
        for (int i = 0; i < array.length; i++) {
            if (_array.indexOf(array[i]) == -1) 
            {
                _array = _array + array[i];     
            }
        }
        return _array;
    }

    private char[][] FillMatrix(char[][] matrix, char[] message, int keylen) {

        int x = 0, y = 0;
        for (int i = 0; i < message.length; i++) {
            matrix[x][y] = message[i];
            if (x == keylen - 1) {
                y++;
                x = 0;
            } else {
                x++;
            }

        }
        return matrix;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Transposition t = new Transposition();
        System.out.println(t.encryptdecrypt("okey its works", "zebras"));

    }
}
