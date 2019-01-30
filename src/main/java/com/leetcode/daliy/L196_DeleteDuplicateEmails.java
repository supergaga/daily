package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/1/29
 * @Description
 */
public class L196_DeleteDuplicateEmails {
    /**
     * Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
     *
     * +----+------------------+
     * | Id | Email            |
     * +----+------------------+
     * | 1  | john@example.com |
     * | 2  | bob@example.com  |
     * | 3  | john@example.com |
     * +----+------------------+
     * Id is the primary key column for this table.
     * For example, after running your query, the above Person table should have the following rows:
     *
     * +----+------------------+
     * | Id | Email            |
     * +----+------------------+
     * | 1  | john@example.com |
     * | 2  | bob@example.com  |
     * +----+------------------+
     * Note:
     *
     * Your output is the whole Person table after executing your sql. Use delete statement.
     */


    /**
     * delete p
     * from person p , person q
     * where p.Email = q.Email and p.Id>q.Id
     */

    /**
     *
     *  没看懂
     *
     * This can be solved by Rank () of MySQL 8.0.
     *
     * delete from Person
     * where (
     * Id in (
     * select a. Id from
     * (select Id, Email, rank()over(partition by Email order by Id asc)as MyRank
     * from Person)a
     * where MyRank<>1
     *    )
     * );
     */

}
