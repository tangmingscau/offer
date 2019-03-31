package com.tangm.leetcode.number50;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * @author tony
 * @date 2019/3/30
 */
public class ValidKuoHao20 {
    public static void main(String[] args) {
        System.out.println(isValid2("[{]}"));
    }

    public static boolean isValid(String s) {
        char[] matchs = new char[]{'(', ')', '{', '}', '[', ']'};
        char[] toMatch = s.toCharArray();
        //观察规则,若index未0的时候出现(,那么)一定是出现在双数index，所以有效括号一定是单双数成对出现
        //所以转换一下思想，所以查看是否匹配，主要查看是否成对出现就好,并且出现的时候是否单双
        //O(3n)
        int n = 0;
        boolean isMatch = true;

        while (n < 6) {
            char left = matchs[n], right = matchs[n + 1];
            Stack<Character> stack = new Stack();
            Stack<Integer> integerStack = new Stack<>();
            for (int i = 0; i < toMatch.length; i++) {
                if (toMatch[i] == left) {
                    stack.push(left);
                    integerStack.push(i);
                }
                if (toMatch[i] == right) {
                    if (stack.empty()) {
                        isMatch = false;
                        break;
                    }
                    char b = stack.pop();
                    int index = integerStack.pop();
                    if (b == left) {
                        if (index % 2 != i % 2) {
                            isMatch = true;
                        } else {
                            isMatch = false;
                            break;
                        }
                    } else {
                        isMatch = false;
                        break;
                    }
                }
            }
            if (!stack.empty()) {
                isMatch = false;
            }
            if (!isMatch) {
                break;
            }
            n += 2;
        }

        return isMatch;
    }

    public static boolean isValid2(String s) {
        //这个是官方解答，和我之前写的思想一样（成对出现，栈原理），不过这里添加多了一个巧妙利用hashmap，性能有些许优化,O(n)
        HashMap<Character, Character> keys = new HashMap<>();
        keys.put(')', '(');
        keys.put(']', '[');
        keys.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (char a : s.toCharArray()) {
            if (keys.containsKey(a)){
                //说明有一个右括号，那么之前一定出现过左括号，否则就是不是有效括号
                char top=stack.isEmpty()?'?':stack.pop();
                if (top!=keys.get(a)){
                    return false;
                }
            }else {
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }
}
