package Level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level5main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Words> wordsList = new ArrayList<>();
        int count = 1;
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령 ) ");
            String command = sc.nextLine().trim();

            if (command.equals("등록")) {
                System.out.println("명언 : ");
                String words = sc.nextLine().trim();
                System.out.println("작자 : ");
                String author = sc.nextLine().trim();

                if (author.isEmpty()) {
                    author = "작자미상";
                }

                wordsList.add(new Words(author, words, count));

                System.out.println(count + "번 명언이 등록되었습니다.");
                count++;

            } else if (command.equals("종료")) {
                break;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-------------------");
                for (Words words : wordsList) {
                    System.out.println(words.countNumber + " / " + words.author + " / " + words.comment);
                }
            } else {
                System.out.println("잘못된 접근 입니다.");
            }
        }
    }
}
