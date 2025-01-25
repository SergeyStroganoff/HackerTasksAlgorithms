package algo.stroganov.west_mortage;

public class ImprovedSolution {


    public static String parseStringToHtmlTable(String input) {
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<table border=\"1\">\n");

        // Разделяем строку по ":" для получения столбцов
        String[] columns = input.split(":");

        // Разделение данных и заголовков
        String[][] data = new String[columns.length][];
        String[] headers = new String[columns.length];


        //TODO: find error in this loop
        for (int i = 0; i < columns.length; i++) {
            String[] parts = columns[i].split(";");
            data[i] = parts[0].split(","); // Получение данных для текущего столбца
            headers[i] = parts[1].trim();    // Получение заголовка для текущего столбца
        }

        // Формирование заголовков таблицы
        htmlTable.append("<tr>\n");
        for (String header : headers) {
            htmlTable.append("  <th>").append(header).append("</th>\n");
        }
        htmlTable.append("</tr>\n");

        // Формирование строк таблицы
        int numRows = data[0].length;
        for (int i = 0; i < numRows; i++) {
            htmlTable.append("<tr>\n");
            for (String[] columnData : data) {
                if (i < columnData.length) {
                    htmlTable.append("  <td>").append(columnData[i].trim()).append("</td>\n");
                } else {
                    htmlTable.append("  <td></td>\n");
                }
            }
            htmlTable.append("</tr>\n");
        }

        htmlTable.append("</table>");
        return htmlTable.toString();
    }

    public static void main(String[] args) {
        String input = "1, 100, 2, 200, 3, 303, 4, 400, 5, 500, 6, 600: column1; " +
                "1,50,2,150,3,250,4,350,5,450,6,550: column2; " +
                "1, 10, 2, 20, 3, 30, 4, 40, 5, 50, 6, 60: column3";

        String htmlTable = parseStringToHtmlTable(input);
        System.out.println(htmlTable);
    }
}

