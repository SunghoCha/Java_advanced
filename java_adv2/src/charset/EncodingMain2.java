package charset;

import javax.print.attribute.standard.MediaSize;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {

    public static final Charset EUC_KR = Charset.forName("EUC-KR");
    public static final Charset MS_949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== 영문 ASCII 인코딩 ==");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1);
        test("A", US_ASCII, EUC_KR);
        test("A", US_ASCII, UTF_8);
        test("A", US_ASCII, UTF_16BE);
        test("A", UTF_8, UTF_16BE);

        System.out.println("== 한글 인코딩 - 기본 케이스 ==");
        test("가", US_ASCII, US_ASCII);
        test("가", ISO_8859_1, ISO_8859_1);
        test("가", EUC_KR, EUC_KR);
        test("가", MS_949, MS_949);
        test("가", UTF_16BE, UTF_16BE);
        test("가", UTF_8, UTF_8);
        test("가", EUC_KR, MS_949);
        test("가", EUC_KR, UTF_16BE);
        test("가", UTF_16BE, UTF_8);
        test("가", EUC_KR, UTF_8);

        System.out.println("== 한글 인코딩 - 복잡한 케이스 ==");
        test("쀍", EUC_KR, EUC_KR);
        test("쀍", MS_949, MS_949);
        test("쀍", UTF_16BE, UTF_16BE);
        test("쀍", UTF_8, UTF_8);

        System.out.println("== 한글 인코딩, 디코딩 다른 경우) ==");
        test("쀍", EUC_KR, MS_949);
        test("쀍", MS_949, EUC_KR);
        test("쀍", EUC_KR, UTF_16BE);
        test("쀍", UTF_16BE, EUC_KR);
        test("쀍", UTF_16BE, UTF_8);
        test("쀍", UTF_8, UTF_16BE);
        test("쀍", EUC_KR, UTF_8);
        test("쀍", UTF_8, EUC_KR);
    }

    public static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] encoded = text.getBytes(encodingCharset);
        String decoded = new String(encoded, decodingCharset);
        boolean result = text.equals(decoded);

        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s : %s\n ",
                text, encodingCharset, Arrays.toString(encoded), encoded.length, decodingCharset, decoded, result);
    }
}
