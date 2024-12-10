package Level7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level7Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Words> wordsList = new ArrayList<>();
        int count = 1;
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령 ) ");
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
                if (wordsList.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                } else {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (int i = wordsList.size() - 1; i >= 0; i--) {
                        Words words = wordsList.get(i);
                        System.out.println(words.countNumber + " / " + words.author + " / " + words.comment);
                    }
                }

            } else if (command.startsWith("삭제?id=")) {
                try {
                    String[] parts = command.split("=");
                    if (parts.length != 2) {
                        System.out.println("잘못된 삭제 명령입니다.");
                        continue;
                    }

                    int idToDelete = Integer.parseInt(parts[1].trim());
                    boolean isDeleted = false;

                    for (int i = 0; i < wordsList.size(); i++) {
                        if (wordsList.get(i).countNumber == idToDelete) {
                            wordsList.remove(i);
                            System.out.println(idToDelete + "번 명언이 삭제되었습니다.");
                            isDeleted = true;
                            break;
                        }
                    }

                    if (!isDeleted) {
                        System.out.println(idToDelete + "번 명언은 존재하지 않습니다.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 ID 형식입니다.");
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

