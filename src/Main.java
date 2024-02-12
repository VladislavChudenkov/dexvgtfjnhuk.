import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Пользователю предлагается ввести координаты первой точки
        System.out.println("Введите координаты первой точки:");
        System.out.print("Широта: ");
        double lat1 = scanner.nextDouble(); // Ввод широты первой точки
        System.out.print("Долгота: ");
        double lon1 = scanner.nextDouble(); // Ввод долготы первой точки

        // Пользователю предлагается ввести координаты второй точки
        System.out.println("Введите координаты второй точки:");
        System.out.print("Широта: ");
        double lat2 = scanner.nextDouble(); // Ввод широты второй точки
        System.out.print("Долгота: ");
        double lon2 = scanner.nextDouble(); // Ввод долготы второй точки

        // Вызов функции для расчета расстояния между точками и сохранение результата в переменной distance
        double distance = calculateDistance(lat1, lon1, lat2, lon2);

        // Вывод расстояния между точками
        System.out.println("Расстояние между точками: " + distance + " км");
    }

    // Функция для расчета расстояния между двумя точками на поверхности Земли по их координатам
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.0; // Радиус Земли в километрах

        // Преобразование координат из градусов в радианы
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Разница между широтами и долготами точек в радианах
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;

        // Вычисление расстояния по формуле гаверсинусового закона
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Расчет и возвращение расстояния между точками
        return R * c;
    }
}
