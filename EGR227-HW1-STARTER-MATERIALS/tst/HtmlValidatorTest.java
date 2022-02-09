// This is JUnit test program stub
// DO NOT CHANGE THE NAME OF THE METHODS GIVEN
// 0) test0 is by the instructor as example to test your validate() method
// 1) You are to reproduce testing validate() method with test1.html-test8.html and
//    match the expected output
// 2) You are to add your own JUnit test for testing your removeAll method (At least 4)
// 3) Feel free to add more test cases to test any of your public methods in HtmlValidatorTest.HtmlValidator (No extra credit, but for your own benefit)

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

public class HtmlValidatorTest {
    /**
     * Below code returns the String format
     * of the content of the given file
     * @param expectedFileName The name of the file that has expected output
     *                         Make sure put relative path in front of
     *                         the file name
     *                         (For example, if your files under tst folder,
     *                         expectedFileName should be "tst/YOUR_FILE_NAME"
     * @return The String format of what the expectedFileName contains
     */
    private static String expectedOutputToString (String expectedFileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner fileScanner = new Scanner(new File(expectedFileName));
            while (fileScanner.hasNextLine()) {
                sb.append(fileScanner.nextLine()+ System.lineSeparator());
            }
        } catch (FileNotFoundException ex) {
            Assert.fail(expectedFileName + "not found. Make sure this file exists. Use relative path to root in front of the file name");
        }
        return sb.toString();
    }

    public static InputStream getInputStream(String address) throws IOException, MalformedURLException {
            // local file
            return new FileInputStream(address);

    }
    public static String readCompleteFileOrURL(String address) throws IOException {
        InputStream stream = getInputStream(address);   // open file

        // read each letter into a buffer
        StringBuffer buffer = new StringBuffer();
        while (true) {
            int ch = stream.read();
            if (ch < 0) {
                break;
            }

            buffer.append((char) ch);
        }
        return buffer.toString();
    }

    /** Below code returns the String format
     * of what your validator's validate prints to the console
     * Feel free to use it so that you can compare it with the expected string
     * @param validator HtmlValidatorTest.HtmlValidator to test
     * @return String format of what HtmlValidatorTest.HtmlValidator's validate outputs
     */
    private static String validatorOutputToString(HtmlValidator validator) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;
        System.setOut(ps);
        validator.validate();
        System.out.flush();
        System.setOut(oldOut);
        return baos.toString();
    }

    /**
     * This test is an instructor given test case to show you some example
     * of testing your validate() method
     * <b>Hi</b><br/> is the hypothetical html file to test
     */
    @Test
    public void test0(){
        //<b>Hi</b><br/>
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(new HtmlTag("b", true));      // <b>
        tags.add(new HtmlTag("b", false));     // </b>
        tags.add(new HtmlTag("br"));           // <br/>
        HtmlValidator validator = new HtmlValidator(tags);

        //Note test0_expected_output.txt is placed under tst. Use relative path!
        Assert.assertEquals(expectedOutputToString("tst/test0_expected_output.txt"),
                            validatorOutputToString(validator));
    }

    /**
     * This test1 method should test your validate() method
     * reproducing the test of
     * input_html/test1.html and expected_output/validate_result_for_test1.txt
     */
	@Test
	public void test1() throws IOException {

        String expected ="expected_output/validate_result_for_test1.txt";
        String address = readCompleteFileOrURL("input_html/test1.html");
        Queue<HtmlTag> tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);


        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}

    /**
     * This test2 method should test your validate() method
     * reproducing the test of
     * input_html/test2.html and expected_output/validate_result_for_test2.txt
     */
	@Test
	public void test2() throws IOException {
        String expected ="expected_output/validate_result_for_test2.txt";
        String address = readCompleteFileOrURL("input_html/test2.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);


        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}


    /**
     * This test3 method should test your validate() method
     * reproducing the test of
     * input_html/test3.html and expected_output/validate_result_for_test3.txt
     */
	@Test
	public void test3() throws IOException {
        String expected ="expected_output/validate_result_for_test3.txt";
        String address = readCompleteFileOrURL("input_html/test3.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);


        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}


    /**
     * This test4 method should test your validate() method
     * reproducing the test of
     * input_html/test4.html and expected_output/validate_result_for_test4.txt
     */
	@Test
	public void test4() throws IOException {
        String expected ="expected_output/validate_result_for_test4.txt";
        String address = readCompleteFileOrURL("input_html/test4.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);


        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}

    /**
     * This test5 method should test your validate() method
     * reproducing the test of
     * input_html/test5.html and expected_output/validate_result_for_test5.txt
     */
	@Test
	public void test5() throws IOException {
        String expected ="expected_output/validate_result_for_test5.txt";
        String address = readCompleteFileOrURL("input_html/test5.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);


        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}

    /**
     * This test1 method should test your validate() method
     * reproducing the test of
     * input_html/test6.html and expected_output/validate_result_for_test6.txt
     */
	@Test
	public void test6() throws IOException {
        String expected ="expected_output/validate_result_for_test6.txt";
        String address = readCompleteFileOrURL("input_html/test6.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);


        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}

    /**
     * This test7 method should test your validate() method
     * reproducing the test of
     * input_html/test7.html and expected_output/validate_result_for_test7.txt
     */
	@Test
	public void test7() throws IOException {
        String expected ="expected_output/validate_result_for_test7.txt";
        String address = readCompleteFileOrURL("input_html/test7.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);

        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}

    /**
     * This test8 method should test your validate() method
     * reproducing the test of
     * input_html/test8.html and expected_output/validate_result_for_test8.txt
     */
	@Test
	public void test8() throws IOException {
        String expected ="expected_output/validate_result_for_test8.txt";
        String address = readCompleteFileOrURL("input_html/test8.html");
        Queue<HtmlTag>tags =HtmlTag.tokenize(address);
        HtmlValidator validator = new HtmlValidator(tags);

        Assert.assertEquals(expectedOutputToString(expected),validatorOutputToString(validator));
	}

	/*
	 * This remove test1 should test my remove all method
     * using input_html/test1.html and the removeAll method
	 * To remove the <i>,</i> of test 1
	 */
	@Test
	public void myRemoveAllTest1() throws IOException{
        //test list
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(HtmlTag.parse("b"));
        tags.add(HtmlTag.parse("/b"));
        tags.add(HtmlTag.parse("i"));
        tags.add(HtmlTag.parse("/i"));

        HtmlValidator test = new HtmlValidator(tags);

        //expected output list
        Queue<HtmlTag> expected = new LinkedList<>();
        expected.add(HtmlTag.parse("b"));
        expected.add(HtmlTag.parse("/b"));

        test.removeAll("i");

        Assert.assertEquals(test.getTags(),expected);
	}

	/*
     * This remove test2 should test my remove all method
     * using removeAll method to remove all elements in a list
	 */
	@Test
	public void myRemoveAllTest2(){
        //test list
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(HtmlTag.parse("b"));
        tags.add(HtmlTag.parse("/b"));
        tags.add(HtmlTag.parse("i"));
        tags.add(HtmlTag.parse("/i"));
        tags.add(HtmlTag.parse("a"));
        tags.add(HtmlTag.parse("/a"));
        tags.add(HtmlTag.parse("html"));
        tags.add(HtmlTag.parse("/html"));

        HtmlValidator test = new HtmlValidator(tags);

        //expected output list
        Queue<HtmlTag> expected = new LinkedList<>();

        test.removeAll("b");
        test.removeAll("a");
        test.removeAll("i");
        test.removeAll("html");

        Assert.assertEquals(test.getTags(),expected);
	}

	/*
	 *removeAllTest3 should expect a false output
	 * when testing the removeAll method to see if there are changes being done
	 */
	@Test
	public void myRemoveAllTest3(){
        //test list
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(HtmlTag.parse("b"));
        tags.add(HtmlTag.parse("/b"));
        tags.add(HtmlTag.parse("i"));
        tags.add(HtmlTag.parse("/i"));

        HtmlValidator test = new HtmlValidator(tags);

        //expected output list
        Queue<HtmlTag> expected = new LinkedList<>();
        expected.add(HtmlTag.parse("b"));
        expected.add(HtmlTag.parse("/b"));
        expected.add(HtmlTag.parse("i"));
        expected.add(HtmlTag.parse("/i"));

        test.removeAll("i");

        Assert.assertEquals(false, test.getTags().equals(expected));
	}

    /*
     *This test should expect a false value
     *when testing to see if the removeAll method would remove both element of the 2 tags
     * <i>, </i>
     */
    @Test
    public void myRemoveAllTest4(){
        //test list
        Queue<HtmlTag> tags = new LinkedList<>();
        tags.add(HtmlTag.parse("b"));
        tags.add(HtmlTag.parse("/b"));
        tags.add(HtmlTag.parse("i"));
        tags.add(HtmlTag.parse("/i"));

        HtmlValidator test = new HtmlValidator(tags);

        //expected output list
        Queue<HtmlTag> expected = new LinkedList<>();
        expected.add(HtmlTag.parse("b"));
        expected.add(HtmlTag.parse("/b"));
        expected.add(HtmlTag.parse("/i"));

        test.removeAll("i");

        Assert.assertEquals(false, test.getTags().equals(expected));
    }





    public static class HtmlTag {
        // fields
        private final String element;
        private final boolean isOpenTag;

        /**
         * Constructs an HTML "opening" tag with the given element (e.g. "table").
         * Throws a NullPointerException if element is null.
         */
        public HtmlTag(String element) {
            this(element, true);
        }

        /**
         * Constructs an HTML tag with the given element (e.g. "table") and type.
         * Self-closing tags like <br /> are considered to be "opening" tags,
         * and return true from the isOpenTag method.
         * Throws a NullPointerException if element is null.
         */
        public HtmlTag(String element, boolean isOpenTag) {
            this.element = element.toLowerCase();
            this.isOpenTag = isOpenTag;
        }

        /**
         * Returns true if this tag has the same element and type as the given other tag.
         */
        public boolean equals(Object o) {
            if (o instanceof HtmlTag) {
                HtmlTag other = (HtmlTag) o;
                return element.equals(other.element) && isOpenTag == other.isOpenTag;
            } else {
                return false;
            }
        }

        /**
         * Returns this HTML tag's element, such as "table" or "p".
         */
        public String getElement() {
            return element;
        }

        /**
         * Returns true if this HTML tag is an "opening" (starting) tag and false
         * if it is a closing tag.
         * Self-closing tags like <br /> are considered to be "opening" tags.
         */
        public boolean isOpenTag() {
            return isOpenTag;
        }

        /**
         * Returns true if the given other tag is non-null and matches this tag;
         * that is, if they have the same element but opposite types,
         * such as <body> and </body>.
         */
        public boolean matches(HtmlTag other) {
            return other != null && element.equalsIgnoreCase(other.element) && isOpenTag != other.isOpenTag;
        }

        /**
         * Returns true if this tag does not requires a matching closing tag,
         * which is the case for certain elements such as br and img.
         */
        public boolean isSelfClosing() {
            return SELF_CLOSING_TAGS.contains(element);
        }

        /**
         * Returns a string representation of this HTML tag, such as "</table>".
         */
        public String toString() {
            return "<" + (isOpenTag ? "" : "/")
                    + (element.equals("!--") ? "!-- --" : element) + ">";
        }


        // a set of tags that don't need to be matched (self-closing)
        private static final Set<String> SELF_CLOSING_TAGS = new HashSet<String>(
                Arrays.asList("!doctype", "!--", "?xml", "xml", "area", "base",
                        "basefont", "br", "col", "frame", "hr", "img",
                        "input", "link", "meta", "param"));

        // all whitespace characters; used in text parsing
        private static final String WHITESPACE = " \f\n\r\t";

        /**
         * Reads a string such as "<table>" or "</p>" and converts it into an HtmlValidatorTest.HtmlTag,
         * which is returned.
         * Throws a NullPointerException if tagText is null.
         */
        public static HtmlTag parse(String tagText) {
            tagText = tagText.trim();
            boolean isOpenTag = !tagText.contains("</");
            String element = tagText.replaceAll("[^a-zA-Z!-?]+", "");
            if (element.contains("!--")) {
                element = "!--";  // HTML comments
            }
            return new HtmlTag(element, isOpenTag);
        }

        /**
         * Reads the file or URL given, and tokenizes the text in that file,
         * placing the tokens into the given Queue.
         * You don't need to call this method in your homework code.
         * Precondition: text != null
         */
        public static LinkedList<HtmlTag> tokenize(String text) {
            StringBuffer buf = new StringBuffer(text);
            LinkedList<HtmlTag> queue = new LinkedList<HtmlTag>();

            while (true) {
                HtmlTag nextTag = nextTag(buf);
                if (nextTag == null) {
                    break;
                } else {
                    queue.add(nextTag);
                }
            }

            return queue;
        }

        // advances to next tag in input;
        // probably not a perfect HTML tag tokenizer, but it will do for this HW
        private static HtmlTag nextTag(StringBuffer buf) {
            int index1 = buf.indexOf("<");
            int index2 = buf.indexOf(">");

            if (index1 >= 0 && index2 > index1) {
                // check for HTML comments: <!-- -->
                if (index1 + 4 <= buf.length() && buf.substring(index1 + 1, index1 + 4).equals("!--")) {
                    // a comment; look for closing comment tag -->
                    index2 = buf.indexOf("-->", index1 + 4);
                    if (index2 < 0) {
                        return null;
                    } else {
                        buf.insert(index1 + 4, " ");    // fixes things like <!--hi-->
                        index2 += 3;    // advance to the closing >
                    }
                }

                String element = buf.substring(index1 + 1, index2).trim();

                // remove attributes
                for (int i = 0; i < WHITESPACE.length(); i++) {
                    int index3 = element.indexOf(WHITESPACE.charAt(i));
                    if (index3 >= 0) {
                        element = element.substring(0, index3);
                    }
                }

                // determine whether opening or closing tag
                boolean isOpenTag = true;
                if (element.indexOf("/") == 0) {
                    isOpenTag = false;
                    element = element.substring(1);
                }
                element = element.replaceAll("[^a-zA-Z0-9!-]+", "");

                buf.delete(0, index2 + 1);
                return new HtmlTag(element, isOpenTag);
            } else {
                return null;
            }
        }
    }

    public class HtmlValidator implements Cloneable {

        private static final String INDENTATION_MARKER = "    "; //4 white spaces

        private Queue<HtmlTag> tags;

        /*an empty HtmlValidator*/
        public HtmlValidator() {
            tags = new LinkedList<>();
        }


        /*an HtmlValidator with the content of tags */
        public HtmlValidator(Queue<HtmlTag> tags) {
            if (tags == null) {
                throw new IllegalArgumentException("Initial tags cannot be null.");
            }
            // Create a deep copy of the input queue:
            this.tags = new LinkedList<>(tags);
        }


        /*Add a tag to the end of the HtmlValidator
         */
        public void addTag(HtmlTag tag) {
            if (tag == null) {
                throw new IllegalArgumentException("Cannot add a null tag.");
            }
            tags.add(tag);
            System.out.println(getTags());
        }


        /*Get a deep copy of the tags in the HtmlValidator
          @return A deep copy of the tags in the HmtlValidator
         */
        public Queue<HtmlTag> getTags() {
            // return a deep copy of the tags - the data structure stored in memory
            // ToDo: what data structure best suits this copy?
            if(tags == null){
                throw new IllegalArgumentException("");
            }
            return tags;
        }


        public void removeAll(String element){
            if(element == null) throw new IllegalArgumentException();

            for(int i =0; i< tags.size(); i++){
                tags.removeIf(tag -> tag.getElement().equalsIgnoreCase(element));
            }
            System.out.println(getTags());
        }

        /*Print formatted HTML based on the content of the HtmlValidator. The output is indented according to tag depth.
         * Unexpected and unclosed tags are printed as error messages at 0 depth
         */
        // check different Html Configurations
        // self Closing Tags
        // Open tags
        // Tags that are not empty
        // Work with the unclosed tags afterwards
        public void validate(){
            int indent = 0;
            Stack<HtmlTag> openTags = new Stack<HtmlTag>();
            HtmlTag currentTag = null;
            for (int i =0; i <tags.size(); i++){
                //Todo: define the htmlTag and how to cycle through the stack
                //Todo: give the needed functionality to move from stack to queue
                currentTag = tags.remove();
                tags.add(currentTag);
                if(currentTag.isSelfClosing()){
                    printWithIndentation(currentTag,indent);
                } else if (currentTag.isOpenTag()){
                    openTags.push(currentTag);
                    printWithIndentation(currentTag, indent);
                    indent++;
                } else{
                    if(!openTags.isEmpty() && currentTag.matches(openTags.peek())){
                        indent--;
                        printWithIndentation(currentTag, indent);
                        openTags.pop();
                    } else {
                        System.out.println("Error unexpected tag: " + currentTag);
                    }
                }
            }
            while(!openTags.isEmpty()){
                System.out.println("Error unclosed tag: " + openTags.pop());
            }
        }

        //Helper function to make printing at given indentation more convenient
        private static void printWithIndentation(HtmlTag tag, int indentationLevel){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i <indentationLevel; i++){
                sb.append(INDENTATION_MARKER);
            }
            sb.append(tag.toString());
            System.out.println(sb.toString());
        }
    }
}

