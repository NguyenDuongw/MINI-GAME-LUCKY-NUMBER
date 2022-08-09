import java.util.Scanner;

public class LuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int Max = 101;
        int randomNum = (int) (Math.random() * Max);

        //Tạo các biến lưu thông tin màn chơi
        int totalGuess = 0;
        int totalGame = 1;
        double guessAvg = 0;
        int bestGame = 999;
        int guessTime = 1;

        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến 100");
        while(true) {
            boolean finish = false;

            //Nhập số từ người dùng
            System.out.print("Bạn đoán? ");
            int guessNum = sc.nextInt();

            //Kiểm tra độ chênh giữa số đoán và số random
            if (guessNum > randomNum) {
                System.out.println("số may mắn bé hơn số dự đoán của bạn.");
                guessTime += 1;
            } else if (guessNum < randomNum) {
                System.out.println("số may mắn lớn hơn số dự đoán của bạn.");
                guessTime += 1;
            } else {
                System.out.println("chúc mừng bạn đã đoán đúng con số may mắn sau " + guessTime + " lần dự đoán");

                //Kiểm tra xem số lần dự đoán lượt chơi này có là nhỏ nhất
                if (bestGame > guessTime) {
                    bestGame = guessTime;
                }

                totalGuess += guessTime;    //+ thêm số lần dự đoán ở màn chơi này vào tổng số lần dự đoán
                guessTime = 1;              //reset số lần đoán mỗi màn chơi
                finish = true;              //tạo cơ sở để thoát vòng lặp
            }

            if(finish){
                System.out.println("bạn có muốn tiếp tục chơi không?");
                String ans = sc.next();
                ans = ans.toLowerCase();

                //Kiểm tra xem người dùng có muốn chơi tiếp
                if ((ans.equals("y")) || (ans.equals("yes"))) {     //có chơi tiếp
                    totalGame += 1;
                    randomNum = (int) (Math.random() * 100);        //tạo lại số ngẫu nhiên mới cho màn sau
                } else {                                            //không chơi nữa
                    break;
                }
            }
        }

        //Sau khi chơi xong thì tiến hành tính toán guesAvg
        guessAvg = Math.round((double) totalGuess / totalGame);

        //Hiển thị thông tin cuối lên console
        report(totalGame, totalGuess, guessAvg, bestGame);
    }

    //Hàm thống báo hiện lên khi trò chơi kết thúc
    public static void report(int totalGame, int totalGuess, double guessAvg, int bestGame) {
        System.out.println("Kết quả tổng quát của trò chơi:");
        System.out.println("Tổng số lần chơi: " + totalGame);
        System.out.println("Tổng số lần dự đoán: " + totalGuess);
        System.out.println("Số lần dự đoán trung bình mỗi lượt: " + guessAvg);
        System.out.println("Số lần dự đoán ít nhất: " + bestGame);
    }
}
