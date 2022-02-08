import java.util.*;

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
//        Queue<HtmlTag> copiedTags = (Queue<HtmlTag>) tags.clone();
//
//        return copiedTags;
        return tags;
    }


    /* Remove all tags matching element
       @param element the type of tag to remove
     */

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
