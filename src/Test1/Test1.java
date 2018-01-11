/*
 * 演示jdbc-odbc桥连方式操作数据库spdb1(emp,dept)
 * 1、配置：控制面板→管理工具→数据源→用户DSN→添加→SQL server→完成→输入名称，服务器local或.→混合模式，输入数据库sa密码→选择数据库
 * 2、程序中连接数据源
 * 
 * jdbc方式操作数据库
 */

package Test1;

import java.sql.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct=null;
		ResultSet rs=null;                                                                    //结果集
		PreparedStatement ps=null;                                                            //preparedstatement会有预编译过程，但statement没有
		
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");                    //加载驱动
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433; DatabaseName=spdb1"
					,"sa","20070401");                                                        //得到连接（指定连接到哪个数据源，用户名密码）
			
			//执行
//			ps=ct.prepareStatement("insert into dept values(?,?,?)");                        //用于发送sql语句到数据库，对于jdbc，sql命令应写在这里，插入语句
//			ps=ct.prepareStatement("delete from dept where deptno=?");                       //删除记录
//			ps=ct.prepareStatement("update dept set loc=? where deptno=?");                  //修改记录
//			ps.setString(1, "上海");                                                          //给问号赋值，2为第二个问号
//			ps.setInt(2, 40);                                                                //给问号赋值，2为第二个问号
//			int i=ps.executeUpdate();                                                        //执行，返回结果
//			if(i==1)
//			{
//				System.out.println("操作成功");
//			}else{
//				System.out.println("操作失败");
//			}
			
			
			//创建
//			ps=ct.prepareStatement("create database vvv");                                   //创建数据库
//			ps=ct.prepareStatement("create table xxx(aa int)");
//			boolean b=ps.execute();                                                          //ddl语句
//			if(!b)
//			{
//				System.out.println("成功");
//			}else{
//				System.out.println("失败");
//			}
			
			//查询
			ps=ct.prepareStatement("select * from dept");
			rs=ps.executeQuery();                                                            //rs指向结果集的第一行的前一行，即表头
			while(rs.next())                                                                 //next方法指向下一个结果
			{
//			    String name=rs.getString(2);                                                 //2为第二列，类型要一致
//			    float sal=rs.getFloat(6);
//				int deptno=rs.getInt(8);
//				System.out.println(name+""+sal+""+deptno);				
			
				int deptno=rs.getInt("deptno");                                              //可以不按列编号get，但列名必须正确
				String name=rs.getString("dname");
				String loc=rs.getString("loc");
				System.out.println(deptno+"，"+name+"，"+loc);
				
			}
			
			
			//备份
//			ps=ct.prepareStatement("backup database bbb to disk='f:/123.bak'");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭资源，后创建先关闭
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
