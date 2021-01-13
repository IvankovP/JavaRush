package level_18.bobr_3_Price2;

/*
Прайсы 2
D:\new.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();

        if (args.length == 0) return;

        int id = 1;
        String findStr = "", nameProduct = "", price = "", quantity = "";
        BufferedWriter writer = null;
        StringBuilder builder = null;
        FileOutputStream fO = null;

        switch (args[0]) {
            case ("-c") :
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));

            while ((findStr = reader.readLine()) != null) {
                id = Math.max(Integer.parseInt(findStr.substring(0, 8).trim()), id);
            }

            reader.close();

            if (args.length > 4) {
                for (int i = 1; i < args.length - 2; i++) {
                    builder.append(args[i] + " ");
                }

                nameProduct = builder.toString();
                price = args[args.length - 2];
                quantity = args[args.length - 1];

                builder = null;
            } else {
                nameProduct = args[1];
                price = args[2];
                quantity = args[3];
            }

            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nameFile, true)));
            writer.newLine();
            String newLine = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", ++id, nameProduct, price, quantity);
            writer.write(newLine);
            writer.close();

            break;

            case ("-u") :
                String idStr = String.format("%-8.8s", args[1]);

                builder = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
                while ((findStr = reader.readLine()) != null) {
                    if (findStr.contains(idStr)) {
                        if (args.length > 4) {

                            StringBuilder builderTmp = new StringBuilder();

                            for (int i = 2; i < args.length - 2; i++) {
                                builderTmp.append(args[i] + " ");
                            }

                            nameProduct = builderTmp.replace(builderTmp.length() - 1, builderTmp.length(), "").toString();
                            price = args[args.length - 2];
                            quantity = args[args.length - 1];

                        } else {
                            nameProduct = args[1];
                            price = args[2];
                            quantity = args[3];
                        }
                        builder.append(String.format("%-8.8s%-30.30s%-8.8s%-4.4s", idStr, nameProduct, price, quantity)).append("\n");
                    }
                    else builder.append(findStr).append("\n");
                }
                builder.replace(builder.length() - 1, builder.length(), "");

                fO = new FileOutputStream(nameFile);
                fO.write(builder.toString().getBytes());

                reader.close();
                fO.close();

                break;

            case ("-d") :
                idStr = String.format("%-8.8s", args[1]);

                builder = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
                while ((findStr = reader.readLine()) != null) {
                    if (!findStr.contains(idStr)) builder.append(findStr).append("\n");
                }
                builder.replace(builder.length() - 1, builder.length(), "");

                fO = new FileOutputStream(nameFile);
                fO.write(builder.toString().getBytes());

                reader.close();
                fO.close();

                break;
        }
    }
}
