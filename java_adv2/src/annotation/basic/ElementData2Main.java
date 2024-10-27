package annotation.basic;

public class ElementData2Main {

    public static void main(String[] args) {
        Class<ElementData2> elementData2Class = ElementData2.class;
        AnnoElement annotation = elementData2Class.getAnnotation(AnnoElement.class);

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
