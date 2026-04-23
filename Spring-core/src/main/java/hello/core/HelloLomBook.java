package hello.core;


import lombok.Getter;
import lombok.Setter;import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLomBook {

    private String name;
    private int age;

    static void main(String[] args) {
        HelloLomBook helloLomBook = new HelloLomBook();
        helloLomBook.setName("adfsf");

        String name = helloLomBook.getName();
        System.out.println("name = " + name);

        System.out.println("helloLomBook = " + helloLomBook);
    }
}
