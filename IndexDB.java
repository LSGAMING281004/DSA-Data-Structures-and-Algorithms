public class IndexDB {
    int index;
    int value;
    int rear = 0;

    int array[] = new int[5];

    int length = array.length;

    // Insert Data
    public String insert(int value) {
        if (rear < length) {
            array[rear] = value;
            rear++;
        } else {
            dynamicDB();
            array[rear] = value;
            rear++;
        }
        return "Successfully Inserted";
    }

    // Update Data
    public String update(int index, int value) {
        if (index <= rear) {
            array[index] = value;

        } else {
            return "Storage is Empty";
        }
        return "Successfully Updated";
    }

    // Delete Data
    public String delete(int index) {
        if (index <= rear) {
            for (int i = index; i < rear - 1; i++) {
                array[i] = array[i + 1];
            }
            rear--;
        } else {
            return "Storage not Support";
        }
        return "Successfully Deleted";
    }

    // View Data
    public void view(int[] arr) {
        for (int num = 0; num < rear; num++) {
            System.out.print(array[num] + " ");
        }
    }

    // Dinamic DB
    public String dynamicDB() {

        int[] newArray = new int[length * 2];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        length = array.length;

        return "Successfully Expanded";
    }

    public static void main(String args[]) {

        IndexDB indexDB = new IndexDB();
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));

        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(55));
        System.out.println(indexDB.insert(57848));

        System.out.println(indexDB.delete(97));
        System.out.println(indexDB.delete(4));

        System.out.println(indexDB.update(1, 999));

        System.out.println(indexDB.insert(567));

        indexDB.view(indexDB.array);

        System.out.println(indexDB.length);

    }
}
