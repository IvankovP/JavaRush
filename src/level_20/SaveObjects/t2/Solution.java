package level_20.SaveObjects.t2;

import level_20.SaveObjects.t1.Asset;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("d:/new2.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users дл объекта javaRush тут
            /*User user = new User();
            user.setFirstName("1111");
            user.setLastName("2222");
            user.setBirthDate(new Date());
            user.setMale(true);
            user.setCountry(User.Country.OTHER);*/

            //javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(this.users.size() + "\n");
            for (User user : users) {
                bufferedWriter.write(user.getFirstName() + "\n");
                bufferedWriter.write(user.getLastName() + "\n");
                bufferedWriter.write(user.getCountry() + "\n");
                bufferedWriter.write(user.isMale() + "\n");
                bufferedWriter.write(user.getBirthDate().getTime() + "\n");
            }
            bufferedWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int countUsers = Integer.parseInt(bufferedReader.readLine());
            if (countUsers > 0) {
                for (int i = 0; i < countUsers; i++) {
                    User user = new User();
                    user.setFirstName(bufferedReader.readLine());
                    user.setLastName(bufferedReader.readLine());
                    user.setCountry(User.Country.valueOf(bufferedReader.readLine()));
                    user.setMale(Boolean.valueOf(bufferedReader.readLine()));
                    user.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
