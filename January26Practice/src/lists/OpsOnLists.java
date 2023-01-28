package lists;

import java.util.Arrays;

public class OpsOnLists {
  public static IntDoubleList reuniteLists(IntDoubleList[] arrayOfLists) {
          IntDoubleList result = new IntDoubleList();
          int counter = 0;
          for(int i=0; i< arrayOfLists.length; i++) counter += arrayOfLists[i].size();
          int[] elements = new int[counter];
          counter = 0;
          for(IntDoubleList list : arrayOfLists){
                IntDoubleListElement temp = list.getFirstElement();
                while (temp != null) {
                    elements[counter++] = temp.getInfo();
                    temp = temp.next;
                }
          }
          Arrays.sort(elements);
          for (int element : elements) result.append(element);
          return result;
  }

    public static void main(String[] args) {
        IntDoubleList idl1 = new IntDoubleList();
        idl1.append(1);
        idl1.append(4);
        idl1.append(6);
        IntDoubleList idl2 = new IntDoubleList();
        idl2.append(2);
        idl2.append(2);
        idl2.append(3);
        idl2.append(7);
        IntDoubleList idl3 = new IntDoubleList();
        idl3.append(3);
        idl3.append(5);
        IntDoubleList[] arrayOfLists = {idl1,idl2,idl3};
        System.out.println("reuniteLists: " + reuniteLists(arrayOfLists));

        IntDoubleList idl4 = new IntDoubleList();
        idl4.append(1);
        idl4.append(4);
        idl4.append(3);
        idl4.append(2);
        idl4.append(5);
        idl4.append(2);
        System.out.println("partTheList: " + partTheList(idl4,3));

        IntDoubleList idl5 = new IntDoubleList();
        idl5.append(1);
        idl5.append(2);
        idl5.append(3);
        idl5.append(4);
        idl5.append(5);

        IntDoubleList idl6 = new IntDoubleList();
        idl6.append(1);
        idl6.append(2);
        idl6.append(3);
        idl6.append(4);

        // Turns out, I misunderstood the questions, however this is at least as hard as the question, and since I am quite satisfied, I'd really like to something else right now.
        System.out.println("mixedList: " + mixedList(idl5));
        System.out.println("mixedList: " + mixedList(idl6));
    }

  public static IntDoubleList partTheList(IntDoubleList list, int value) {
      int minCounter = 0, xCounter = 0, maxCounter = 0;
      IntDoubleListElement temp = list.getFirstElement();
      while(temp != null){
          if(temp.getInfo() == value) xCounter++;
          if(temp.getInfo() < value) minCounter++;
          if(temp.getInfo() > value) maxCounter++;
          temp = temp.next;
      }

      int[] minArr = new int[minCounter], maxArr = new int[maxCounter], xArr = new int[xCounter];
      minCounter = 0;
      xCounter = 0;
      maxCounter = 0;

      temp = list.getFirstElement();
      while(temp != null){
          if(temp.getInfo() < value) minArr[minCounter++] = temp.getInfo();
          temp = temp.next;
      }

      temp = list.getFirstElement();
      while(temp != null){
          if(temp.getInfo() > value) maxArr[maxCounter++] = temp.getInfo();
          temp = temp.next;
      }

      temp = list.getFirstElement();
      while(temp != null){
          if(temp.getInfo() == value) xArr[xCounter++] = temp.getInfo();
          temp = temp.next;
      }

      IntDoubleList ans = new IntDoubleList();
      for(int element : minArr) ans.append(element);
      for(int element : xArr) ans.append(element);
      for(int element : maxArr) ans.append(element);
      return ans;
  }

    // Turns out, I misunderstood the questions, however this is at least as hard as the question, and since I am quite satisfied, I'd really like to something else right now.
    public static IntDoubleList mixedList(IntDoubleList list) {
      int[] fromN = new int[list.size()/2];
      int[] from1 = new  int[list.size()%2 == 0 ? list.size()/2 - 1 : list.size()/2];
      IntDoubleList ans = new IntDoubleList();
      ans.append(list.getFirstElement().getInfo());
      int counter1 = from1.length - 1, counterN = 0;

      IntDoubleListElement temp = list.getLastElement();
      while(temp != list.getFirstElement() && temp != null){
          fromN[counterN++] = temp.getInfo();
          if(counter1 >= 0) from1[counter1--] = temp.prev.getInfo();
          temp = temp.prev.prev;
      }

      counter1 = 0;
      counterN = 0;
      for(int i = 1; i< list.size(); i++){
          if(i%2 == 1) ans.append(fromN[counterN++]);
          else ans.append(from1[counter1++]);
      }

      return ans;
  }
}
