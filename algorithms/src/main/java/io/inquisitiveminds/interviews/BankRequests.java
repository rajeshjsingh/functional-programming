package io.inquisitiveminds.interviews;

import java.util.Arrays;

/**
 * * Bank Requests
 *  *
 *  * You've been asked to program a bot for a popular bank that will automate the management of incoming requests. There are three types of requests the bank can receive:
 *  *  transfer i j sum: request to transfer sum amount of money from the ith account to the jth one;
 *  *  deposit i sum: request to deposit sum amount of money in the ith account;
 *  *  withdraw i sum: request to withdraw sum amount of money from the ith account.
 *  *
 *  * Your bot should also be able to process invalid requests. There are two types of invalid requests:
 *  *      invalid account number in the requests;
 *  *      deposit / withdrawal of a larger amount of money than is currently available.
 *  *
 *  * For the given list of accounts and requests, return the state of accounts after all requests have been processed, or an array of a single element [-<request_id>]
 *  * (please note the minus sign), where <request_id> is the 1-based index of the first invalid request.
 *  *
 *  * Example
 *  *  For accounts = [10, 100, 20, 50, 30] and requests = ["withdraw 2 10", "transfer 5 1 20", "deposit 5 20", "transfer 3 4 15"],
 *  *  the output should be bankRequests(accounts, requests) = [30, 90, 5, 65, 30].
 *  *
 *  *  Here are the states of accounts after each request:
 *  *      "withdraw 2 10": [10, 90, 20, 50, 30];
 *  *      "transfer 5 1 20": [30, 90, 20, 50, 10];
 *  *      "deposit 5 20": [30, 90, 20, 50, 30];
 *  *      "transfer 3 4 15": [30, 90, 5, 65, 30], which is the answer.
 *  *
 *  *  For accounts = [20, 1000, 500, 40, 90] and requests = ["deposit 3 400", "transfer 1 2 30", "withdraw 4 50"],
 *  *  the output should be bankRequests(accounts, requests) = [-2].
 *  *
 *  *  After the first request, accounts becomes equal to [20, 1000, 900, 40, 90], but the second one turns it into [-10, 1030, 900, 40, 90], which is invalid.
 *  *  Thus, the second request is invalid, and the answer is [-2]. Note that the last request is also invalid, but it shouldn't be included in the answer.
 */
public class BankRequests {
    public static void main(String[] args) {

        int[] accounts = {10, 100, 20, 50, 30};
        String[] requests = {"withdraw 2 10", "transfer 5 1 20", "deposit 5 20", "transfer 3 4 15"};

/*
        int[] accounts = {0, 1000, 500, 40, 90};
        String[] requests = {"deposit 3 400", "transfer 1 2 30", "withdraw 4 50"};
*/


        Arrays.stream(bankRequests(accounts,requests)).forEach((i) -> System.out.println(i));

    }

    private static  int[] bankRequests(int[] accounts, String[] requests) {
        for(int i = 0 ; i < requests.length; i++){
            String[] request = requests[i].split(" ");
            if(request[0].equals("withdraw")) {
                int accountIndex = Integer.valueOf(request[1]) -1;
                int sum = Integer.valueOf(request[2]);
                if (accountIndex >= accounts.length || accounts [accountIndex] < sum) return new int [] { - (i + 1) };
                accounts [accountIndex] -= sum;

            }
            else if(request[0].equals("transfer")) {
                int account1Index = Integer.valueOf(request[1]) -1;
                int account2Index = Integer.valueOf(request[2]) -1;
                int sum = Integer.valueOf(request[3]);

                if (account1Index >= accounts.length ||  account2Index >= accounts.length || accounts [account1Index] < sum) return new int [] { - (i + 1) };
                accounts [account1Index] -= sum;
                accounts [account2Index] += sum;
            }
            else if(request[0].equals("deposit")) {
                int accountIndex = Integer.valueOf(request[1]) -1;
                int sum = Integer.valueOf(request[2]);
                if(accountIndex >= accounts.length ) return new int [] { - (accountIndex + 1) };
                sum+= accounts[accountIndex];
                accounts[accountIndex] = sum;

            } else {
                return new int [] { - (i + 1) };
            }
        }

        return  accounts;
    }

}
