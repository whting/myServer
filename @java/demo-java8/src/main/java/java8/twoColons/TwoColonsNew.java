package java8.twoColons;

class TwoColonsNew {
	public String name;

	public TwoColonsNew(String name) {
		this.name = name;
		// System.out.println(this.name);
	}

	public TwoColonsNew twoColonsNew(String name) {
		return this;
	}

	public static void main(String[] args) {

		TwoColonsInterface si_temp = new TwoColonsNew("loader temp")::twoColonsNew;
		TwoColonsNew twoC_temp = si_temp.build("loader");
		System.out.println(twoC_temp.name);

		TwoColonsInterface si = TwoColonsNew::new;
		TwoColonsNew twoC = si.build("loader");
		System.out.println(twoC.name);
	}
}

@FunctionalInterface
interface TwoColonsInterface {
	// 返回构造对象
	TwoColonsNew build(String name);
}
