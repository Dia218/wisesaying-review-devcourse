import java.util.Scanner;

public class Level4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

                System.out.println(count + "번 명언이 등록되었습니다.");
                count++;
            } else if (command.equals("종료")) {
                break;
            } else {
                System.out.println("잘못된 접근 입니다.");
            }
        }
    }

}
