package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) {
		// TODO: implement, see exercise P-4.16
		// Collections.sort(list);
		List<Elem> res = new ArrayList<Elem>();
		if (list.size() <= 1) {
			// res = list;
			return;
		}
		int mid = list.size() / 2;
		List<Elem> templ = list.subList(0, mid);
		List<Elem> tempr = list.subList(mid, list.size());
		List<Elem> left = new ArrayList<Elem>();
		List<Elem> right = new ArrayList<Elem>();
		left.addAll(templ);
		right.addAll(tempr);
		mergesort(left);
		mergesort(right);
		int fi = 0;
		int si = 0;
		while (fi < left.size() && si < right.size()) {

			if (left.get(fi).compareTo(right.get(si)) < 0) {
				res.add(left.get(fi));
				fi += 1;
			} else {
				res.add(right.get(si));
				si += 1;
			}

		}
		if (fi <= left.size()) {
			res.addAll(left.subList(fi, left.size()));

		}

		if (si <= right.size()) {
			res.addAll(right.subList(si, right.size()));

		}

		list.clear();
		list.addAll(res);

	}

}
