package org.teiphu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
//		helper(res, "", 0, 0, n);
		helper(res, n, n, "");
		return res;
	}

	private void helper(List<String> res, int left, int right, String s) {
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}
		if (left > 0) {
			helper(res, left - 1, right, s + '(');
		}
		if (left < right) {
			helper(res, left, right - 1, s + ')');
		}
	}

	private void helper(List<String> res, String s, int l, int r, int n) {
		if (n < 1 || n < r || r > 1) {
			return;
		}
		if (l == n && r == n) {
			res.add(s);
			return;
		}
		helper(res, s + '(', l + 1, r, n);
		helper(res, s + ')', l, r + 1, n);
		return;
	}

}
