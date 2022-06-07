import javafx.scene.image.Image;

public abstract class Block {
	private Image img;
	private int Id;
	private String name;
	private String aspectInfo;
	private boolean isstatic;

	public Block() {

	}

	public Block(int Id, String name, String aspectInfo) {
		setId(Id);
		setName(name);
		setAspectInfo(aspectInfo);
		if (name.equals("Starter")) {
			setIsstatic(true);
			if (aspectInfo.equals("Vertical")) {
				setImg(new Image("images\\starterVertical.png"));
			} else {
				setImg(new Image("images\\starterHorizontal.png"));
			}
		} else if (name.equals("End")) {
			setIsstatic(true);
			if (aspectInfo.equals("Vertical")) {
				setImg(new Image("images\\endVertical.png"));
			} else {
				setImg(new Image("images\\endHorizontal.png"));
			}
		} else if (name.equals("PipeStatic")) {
			setIsstatic(true);
			if (aspectInfo.equals("Vertical")) {
				setImg(new Image("images\\staticVertical.png"));
			} else if (aspectInfo.equals("Horizontal")) {
				setImg(new Image("images\\staticHorizontal.png"));
			} else if (aspectInfo.equals("00")) {
				setImg(new Image("images\\static00.png"));
			} else if (aspectInfo.equals("01")) {
				setImg(new Image("images\\static01.png"));
			} else if (aspectInfo.equals("10")) {
				setImg(new Image("images\\static10.png"));
			} else if (aspectInfo.equals("11")) {
				setImg(new Image("images\\static11.png"));
			}
		} else if (name.equals("Pipe")) {
			setIsstatic(false);
			if (aspectInfo.equals("Vertical")) {
				setImg(new Image("images\\pipeVertical.png"));
			} else if (aspectInfo.equals("Horizontal"))
				setImg(new Image("images\\pipeHorizontal.png"));
			else if (aspectInfo.equals("00")) {
				setImg(new Image("images\\pipe00.png"));
			} else if (aspectInfo.equals("01"))
				setImg(new Image("images\\pipe01.png"));
			else if (aspectInfo.equals("10")) {
				setImg(new Image("images\\pipe10.png"));
			} else if (aspectInfo.equals("11"))
				setImg(new Image("images\\pipe11.png"));
		} else if ((name.equals("Empty") && (aspectInfo.equals("Free")))) {
			setIsstatic(false);
			setImg(new Image("images\\emptyFree.png"));
		} else if (name.equals("Empty") && (aspectInfo.equals("none"))) {
			setIsstatic(false);
			setImg(new Image("images\\empty.png"));
		}
	}

	// Setters and Getters

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAspectInfo() {
		return aspectInfo;
	}

	public void setAspectInfo(String aspectInfo) {
		this.aspectInfo = aspectInfo;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean isIsstatic() {
		return isstatic;
	}

	public void setIsstatic(boolean isstatic) {
		this.isstatic = isstatic;
	}

	// Setters and Getters
}
