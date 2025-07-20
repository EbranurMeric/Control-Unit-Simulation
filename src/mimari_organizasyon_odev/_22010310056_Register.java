package mimari_organizasyon_odev;


	public class _22010310056_Register {
		private String name;

		public _22010310056_Register (String name) {
			this.name = name;
		}

		public void load() {
			System.out.println(name + " register'ının Load girişi aktif olur.");
		}

		public void increment() {
			System.out.println(name + " register'ının Increment girişi aktif olur.");
		}

		public void clear() {
			System.out.println(name + " register'ının Clear girişi aktif olur.");
		}
	}

