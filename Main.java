public class Main {
          public static void main(String[] args) {
            String[][] correctMatrix = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "1", "0", "1"},
                    {"1", "1", "2", "1"}
            };
            String[][] wrongSizeMatrix = {
                    {"1"},
                    {"5", "6"},
                    {"9", "1", "0"},
                    {"1", "1", "2", "1"}
            };
            String[][] wrongChar = {
                    {"1", "", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "1", "0", "1"},
                    {"1", "1", "2", "1"}
            };

            try {
                System.out.println(Converter.strConverter(correctMatrix));
            } catch (CustomException e) {
                e.getMessage();
            }


            try {
                System.out.println(Converter.strConverter(wrongSizeMatrix));
            } catch (CustomException e) {
                System.err.println(e.getMessage());
            }

            try {
                System.out.println(Converter.strConverter(wrongChar));
            } catch (CustomException e) {
                System.err.println(e.getMessage());
            }
    }
    }