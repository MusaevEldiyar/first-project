import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] shoppingList = new String[8];
        int productCount = 0;

        System.out.println("Вас приветствует список покупок!");

        // Запускаем бесконечный цикл, для возвращения меню
        while (true) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");
            System.out.print("Ваш выбор: ");

            int actionNumber = scanner.nextInt();
            scanner.nextLine(); // Перенос строки

            switch (actionNumber) {
                // Добавление товара
                case 1:
                    // Проверка на заполнение массива
                    if (productCount == shoppingList.length) {
                        // Создаем новый массив большего размера
                        String[] newArray = new String[shoppingList.length * 2];
                        // Копируем элементы из старого массива в новый
                        System.arraycopy(shoppingList, 0, newArray, 0, shoppingList.length);
                        // Обновляем ссылку на массив
                        shoppingList = newArray;
                    }

                    System.out.print("Введите товар: ");
                    String productName = scanner.nextLine();
                    // Заменяем пробелы на подчеркивания
                    productName = productName.replace(" ", "_");

                    boolean isDouble = false; // Флаг дубли

                    // Проверяем каждый элемент массива на совпадение
                    for (int i = 0; i < productCount; i++) {
                        if (shoppingList[i].equals(productName)) {
                            System.out.println("Такой товар уже есть в списке");
                            isDouble = true;
                        }
                    }

                    if (!isDouble) {
                        shoppingList[productCount] = productName;
                        System.out.println("Товар " + productName + " добавлен в список под номером "+productCount);

                        productCount++;
                    }
                    break;
                // Список товаров
                case 2:
                    if (productCount == 0) {
                        System.out.println("Список товаров пуст.");
                    } else {
                        System.out.println("Список товаров:");
                        for (int i = 0; i < productCount; i++) {
                            System.out.println(i + 1 + ". " + shoppingList[i]);
                        }
                    }
                    break;
                // Очистка списка
                case 3:
                    if (productCount == 0) {
                        System.out.println("Список товаров пуст");
                    } else {
                        for (int i = 0; i < productCount; i++) {
                            shoppingList[i] = null;
                        }
                        productCount = 0;

                        System.out.println("Список товаров очищен");
                    }
                    break;
                // Завершение работы
                case 4:
                    System.out.println("Завершение работы");
                    return;
                default:
                    System.out.println("Неизвестная комманда");
                    break;
            }
        }
    }
}