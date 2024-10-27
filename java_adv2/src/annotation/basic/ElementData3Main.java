package annotation.basic;

public class ElementData3Main {

    public static void main(String[] args) {
        Class<ElementData3> elementData3Class = ElementData3.class;
        AnnoElement annotation = elementData3Class.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        System.out.println("value = " + value);

        int count = annotation.count();
        System.out.println("count = " + count);

        String[] tags = annotation.tags();
        for (String tag : tags) {
            System.out.println("tag = " + tag);
        }
    }
}
