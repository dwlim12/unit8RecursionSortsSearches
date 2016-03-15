import java.util.*;
public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = new ArrayList<Integer>(n);
        if (n <= 0)  // The smallest list we can make
        {
            return tempList;
        }
        else        // All other size lists are created here
        {
            tempList = makeList(n-1);  //Solve the smaller problem
            tempList.add(n);           //Use it to solve the larger problem
            return tempList;
        }
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> list) 
    {
        ArrayList<Integer> tempList2 = ListMethods.deepClone(list);
        if (tempList2.size() <= 1)  // The smallest list we can make
        {
            return tempList2;
        }
        else        // All other size lists are created here
        {
            int tempInt = list.remove(0);
            tempList2 = ListMethods.reverseList(list);
            tempList2.add(tempInt);
        }
        return tempList2;
    }

    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (Integer i : tList)
        {
            list.add(new Integer(i));
        }
        return list;
    }
    
    public static ArrayList<Integer> even(ArrayList<Integer> list) 
    {
        ArrayList<Integer> tempList2 = ListMethods.deepClone(list);
        if (tempList2.size() <= 1)  // The smallest list we can make
        {
            return tempList2;
        }
        else        // All other size lists are created here
        {
            Integer tempInt = list.remove(0);
            tempList2.remove(0);
            tempList2 = ListMethods.even(tempList2);
            tempList2.add(0, tempInt);
        }
        return tempList2;
    }
    
    public static ArrayList<Integer> merge(ArrayList<Integer> list, ArrayList<Integer> list2) 
    {
        ArrayList<Integer> tempList1 = ListMethods.deepClone(list);
        ArrayList<Integer> tempList2 = ListMethods.deepClone(list2);
        ArrayList<Integer> tempList;
        if (tempList1.size() == 0)  // The smallest list we can make
        {
            return tempList2;
        }
        else if (tempList2.size() == 0)       // All other size lists are created here
        {
            return tempList1;
        }
        else
        {
            Integer lastElement1 = tempList1.get(tempList1.size() - 1);
            Integer lastElement2 = tempList2.get(tempList2.size() - 1);
            if (lastElement1.compareTo(lastElement2) < 0)
            {
                //Remove the largest element in list2
                lastElement2 = tempList2.remove(tempList2.size() - 1);
                //Now merge the lists recursively
                tempList = ListMethods.merge(tempList1, tempList2);
                //Add back the largest element
                tempList.add(lastElement2);
            }
            else
            {
                //Remove the largest element in list1
                lastElement1 = tempList1.remove(tempList1.size() - 1);
                //Now merge the lists recursively
                tempList = ListMethods.merge(tempList1, tempList2);
                //Add back the largest element
                tempList.add(lastElement1);
            }
        }
        return tempList;
    }
}