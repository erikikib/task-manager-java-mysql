package com.erika;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TaskDAO dao = new TaskDAO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Task Manager: add <title> | list | toggle <id> | del <id> | quit");
        while (true) {
            System.out.print("> ");
            if (!sc.hasNext()) break;
            String cmd = sc.next();
            if (cmd.equals("add"))       { dao.create(sc.nextLine().trim()); }
            else if (cmd.equals("list")) { dao.list().forEach(System.out::println); }
            else if (cmd.equals("toggle")) { dao.toggleDone(sc.nextInt()); }
            else if (cmd.equals("del"))  { dao.delete(sc.nextInt()); }
            else if (cmd.equals("quit")) { break; }
            else { System.out.println("Unknown command"); sc.nextLine(); }
        }
        sc.close();
    }
}
