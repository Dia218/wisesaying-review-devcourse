package Level8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level8Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 1;
        List<Words> wordsList = new ArrayList<>();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령 ) ");
            String command = sc.nextLine().trim();

            if (command.equals("등록")) {
                System.out.print("명언 : ");
                String comment = sc.nextLine().trim();
                System.out.print("작자 : ");
                String author = sc.nextLine().trim();

                if (author.isEmpty()) {
                    author = "작자미상";
                }

                wordsList.add(new Words(author, comment, count));
                System.out.println(count + "번 명언이 등록되었습니다.");
                count++;

            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------------");
                for (int i = wordsList.size() - 1; i >= 0; i--) {
                    System.out.println(wordsList.get(i).indexId + " / " + wordsList.get(i).author + " / " + wordsList.get(i).words);

                }
            } else if (command.startsWith("삭제?id=")) {
                try {
                    String[] str = command.split("=");

                    if (str.length != 2) {
                        System.out.println("잘못된 입력 방식입니다.");
                        continue;
                    }
                    int deleteNumber = Integer.parseInt(str[1].trim());
                    boolean deletedNumber = false;
                    for (int i = 0; i < wordsList.size(); i++) {
                        if (deleteNumber == wordsList.get(i).indexId) {
                            wordsList.remove(deleteNumber-1);
                            System.out.println(deleteNumber + "번 명언이 삭제되었습니다.");
                            deletedNumber = true;
                            break;
                        }
                    }
                    if (!deletedNumber) {
                        System.out.println(deleteNumber + "번 명언은 존재 하지 않습니다.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 입력 방식입니다.");
                }
            } else if (command.startsWith("수정?id=")) {
                try {
                    int id = Integer.parseInt(command.split("=")[1]);
                    Words words = wordsList.get(id-1);
                    if (words != null) {
                        System.out.println("명언(기존) : " + words.words);
                        System.out.print("명언(수정) : ");
                        words.words = sc.nextLine().trim();
                        System.out.println("작가(기존) : " + words.author);
                        System.out.print("작가(수정) : ");
                        words.author = sc.nextLine().trim();

                        System.out.println(id + " 번 명언이 수정되었습니다.");
                    } else {
                        System.out.println("해당 명언이 존재하지 않습니다.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 명령입니다.");
                }
            } else if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("잘못된 명령입니다.");
            }
        }

        sc.close();
    }
}


