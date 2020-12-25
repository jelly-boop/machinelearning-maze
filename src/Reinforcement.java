
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

public class Reinforcement {

   ArrayList<Integer> newPoint = new ArrayList<Integer>();//�� ����Ʈ
   ArrayList<Integer> points = new ArrayList<Integer>();//���ݱ����� ����Ʈ ����
   
   int reward = 50;
   String[] moveType = { "��", "��", "��", "��" };
   int temp1 = 0;
   int temp2 = 0;
   int size = 0;
   

   public ArrayList move(JLabel[][] grid, int r, int c) {
      newPoint.clear();
      String move = moveType[(int) (Math.random() * 4)];
      
      //���� ����Ʈ ����
      temp1 = r;
      temp2 = c;
      


      if (c == 0) {
         if (r == size) {
            // ��
            if (move.equals("��")) {
               c++;
            }

         } else {
            // ����
            if (move.equals("��")) {
               c++;
            }else if (move.equals("��")) {
               r++;
            }
         }
      } else if (c == size) {
         if (r == 0) {
            // ����
            if (move.equals("��")) {
               c++;
            }else if (move.equals("��")) {
               r++;
            }
         } else {
            // ��
            if (move.equals("��")) {
               r++;
            }
         }
      } else {
         if (r == size) {
            // ��
            if (move.equals("��")) {
               c++;
            }
         } else {
            // ����
            if (move.equals("��")) {
               c++;
            }else if (move.equals("��")) {
               r++;
            }
         }
      }
      if(r>size||c>size) {//�������� ������
         r=temp1;
         c=temp2;
      }
      if (grid[r][c].getBackground().equals(Color.black)||
            grid[r][c].getBackground().equals(Color.gray)) {//��ֹ� ������
         reward-=5;
         if(reward==0) {//���������� �Ұ� �� ����Ʈ�� ������
            System.out.println("������ 0");
            reward=50;
            newPoint.add(points.get(points.size()-4));
            newPoint.add(points.get(points.size()-3));
            
         }else {//��������Ʈ��..
            newPoint.add(temp1);
            newPoint.add(temp2);
         }
         
      }else {
         //���ٸ� ���ο� ����Ʈ
         newPoint.add(r);
         newPoint.add(c);
      }


      return newPoint;

   }

   public void setSize(int SIZE) {
      this.size = SIZE - 1;

   }

   public void giveList(ArrayList<Integer> pointList) {
      this.points=pointList;
      
   }

}