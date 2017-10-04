import java.io.Serializable;
import java.util.UUID;

public class Model implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		String id=UUID.randomUUID().toString();
		String name ;
		
		public Model(String name){
			this.name=name;
		}
		
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
