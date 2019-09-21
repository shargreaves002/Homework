public class Permutation {
    private StringBuilder answer = new StringBuilder();
    private Integer[] arr = new Integer[]{};

    public Permutation (Integer[] array) {
        this.arr = array;
    }
    public void printPermutn() {
        printPermutn(arr.length, arr);
    }
    private void printPermutn(int index, Integer[] elements) {
        if(index == 1) {
            printArray(elements);
        } else if (index > 1){
            for(int i = 0; i < index-1; i++) {
                printPermutn(index - 1, elements);
                if(index % 2 == 0) {
                    swap(elements, i, index-1);
                } else {
                    swap(elements, 0, index-1);
                }
            }
            printPermutn(index - 1, elements);
            if (index == elements.length) {
                System.out.println(answer.substring(0, answer.lastIndexOf(",")));
            }
        }
    }

    private void swap(Integer[] input, int a, int b) {
        Integer tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private void printArray(Integer[] input) {
        for (Integer integer : input) {
            answer.append(integer);
        }
        answer.append(", ");
    }
}
