package Level6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level6main {
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

                for (int i = wordsList.size() - 1; i >= 0; i--) {
                    Words quote = wordsList.get(i);
                    System.out.println(quote.countNumber + " / " + quote.author + " / " + quote.comment);
                }
            } else if (command.startsWith("삭제?id=")) {
                try {
                    int idToDelete = Integer.parseInt(command.split("=")[1]);
                    boolean isDeleted = false;

                    for (int i = 0; i < wordsList.size(); i++) {
                        if (wordsList.get(i).countNumber == idToDelete) {
                            wordsList.remove(i);
                            System.out.println(idToDelete + "번 명언이 삭제되었습니다");
                            isDeleted = true;
                            break;
                        }
                    }
                    if (!isDeleted) {
                        System.out.println("해당 ID의 명언이 존재하지 않습니다.");
                    }
                } catch (Exception e) {
                    System.out.println("잘못된 삭제 명령입니다.");

                }


            } else {
                System.out.println("잘못된 접근 입니다.");
            }
        }
    }
}
