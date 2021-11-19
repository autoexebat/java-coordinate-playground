package coordinate.view;

import java.util.Scanner;

public class InputVIew {
    private Scanner scanner = new Scanner(System.in);
    public String input() {
        return scanner.nextLine();
    }
    public void init() {
        System.out.println("좌표를 입력하세요.");
    }
}
