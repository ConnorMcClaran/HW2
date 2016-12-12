import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by mcclarci on 11/15/2016.
 */


class Node{

    public String data;
    public Node next;

    public Node(String data){
    this.data = data;
    }

    public Node(){}

    public void displayNode()
    {System.out.println(data);}
}

class LinkList
{
    private Node first;

    public LinkList()
    {first = null;}




    public void insert(String input)
    {

        Node enterNode = new Node(input);
        enterNode.next = first;
        first = enterNode;
    }

    public void combine(Node result)
    {
        first = result;
    }

    public void display()
    {//Displays the linked list

        System.out.println("List: ");
        Node current = first;
        while(current != null)
        {
            current.displayNode();
            current = current.next;
        }

        System.out.println();
    }

    public Node getFirst()
    {return first;}


    public Node mergeSort(Node head)
    {//mergeSort method

        if (head == null || head.next == null)
        {
            return head;
        }


        Node a = head;
        Node b = head.next;

        while ((b != null) && (b.next != null))
        {
            head = head.next;
            b = b.next.next;
        }

        b = head.next;
        head.next = null;


        return merge(mergeSort(a), mergeSort(b));
    }

    public Node merge(Node a, Node b)
    {
        Node fakeHead = new Node();
        Node current = fakeHead;

        while((a != null) && (b != null))
        {
            if(a.data.compareTo(b.data) < 0)
            {
                current.next = a;
                current = a;
                a = a.next;
            }
            else
            {
                current.next = b;
                current = b;
                b = b.next;
            }
        }


        current.next = (a == null) ? b : a;
        return fakeHead.next;
    }
}

/**
 Sorts the list by city name
 */
public class DMALinkedList
{
    public static void main(String[] args) throws IOException
    {
        String filename = "dma.txt";

        File file = new File(filename);
        Scanner readFile = new Scanner(file).useDelimiter("[,\n]");

        LinkList theList = new LinkList();

        String number = "";
        String city = "";
        String state = "";

        while(readFile.hasNext())
        {
            number = readFile.next();
            city = readFile.next();
            state = readFile.next();
            theList.insert(city + "," + number + "," + state);
        }
        theList.display();
        System.out.println("Sorted List)");
        theList.combine(theList.mergeSort(theList.getFirst()));
        theList.display();
    }
}