/*
 * ��ʾjdbc-odbc������ʽ�������ݿ�spdb1(emp,dept)
 * 1�����ã��������������ߡ�����Դ���û�DSN����ӡ�SQL server����ɡ��������ƣ�������local��.�����ģʽ���������ݿ�sa�����ѡ�����ݿ�
 * 2����������������Դ
 * 
 * jdbc��ʽ�������ݿ�
 */

package Test1;

import java.sql.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		ResultSet rs=null;                                                                    //�����
		PreparedStatement ps=null;                                                            //preparedstatement����Ԥ������̣���statementû��
		
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");                    //��������
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=spdb1"
					,"sa","20070401");                                                        //�õ����ӣ�ָ�����ӵ��ĸ�����Դ���û������룩
			
			//ִ��
//			ps=ct.prepareStatement("insert into dept values(?,?,?)");                        //���ڷ���sql��䵽���ݿ⣬����jdbc��sql����Ӧд������������
//			ps=ct.prepareStatement("delete from dept where deptno=?");                       //ɾ����¼
//			ps=ct.prepareStatement("update dept set loc=? where deptno=?");                  //�޸ļ�¼
//			ps.setString(1, "�Ϻ�");                                                          //���ʺŸ�ֵ��2Ϊ�ڶ����ʺ�
//			ps.setInt(2, 40);                                                                //���ʺŸ�ֵ��2Ϊ�ڶ����ʺ�
//			int i=ps.executeUpdate();                                                        //ִ�У����ؽ��
//			if(i==1)
//			{
//				System.out.println("�����ɹ�");
//			}else{
//				System.out.println("����ʧ��");
//			}
			
			
			//����
//			ps=ct.prepareStatement("create database vvv");                                   //�������ݿ�
//			ps=ct.prepareStatement("create table xxx(aa int)");
//			boolean b=ps.execute();                                                          //ddl���
//			if(!b)
//			{
//				System.out.println("�ɹ�");
//			}else{
//				System.out.println("ʧ��");
//			}
			
			//��ѯ
			ps=ct.prepareStatement("select * from dept");
			rs=ps.executeQuery();                                                            //rsָ�������ĵ�һ�е�ǰһ�У�����ͷ
			while(rs.next())                                                                 //next����ָ����һ�����
			{
//			    String name=rs.getString(2);                                                 //2Ϊ�ڶ��У�����Ҫһ��
//			    float sal=rs.getFloat(6);
//				int deptno=rs.getInt(8);
//				System.out.println(name+""+sal+""+deptno);				
			
				int deptno=rs.getInt("deptno");                                              //���Բ����б��get��������������ȷ
				String name=rs.getString("dname");
				String loc=rs.getString("loc");
				System.out.println(deptno+"��"+name+"��"+loc);
				
			}
			
			
			//����
//			ps=ct.prepareStatement("backup database bbb to disk='f:/123.bak'");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ���󴴽��ȹر�
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(ct!=null)ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
