package pl.jw.library.model;

import pl.jw.library.exception.PublicationAlreadyExistsException;
import pl.jw.library.exception.UserAlreadyExistsExceptions;

import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {

    private final Map<String, Publication> publications = new HashMap<>();
    private final Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Collection<Publication> getSortedPublications(Comparator<Publication> comparator) {
        List<Publication> list = new ArrayList<>(publications.values());
        list.sort(comparator);
        return list;
    }

    public Optional<Publication> findPublicationByTitle(String title) {
        return Optional.ofNullable(publications.get(title));
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Collection<LibraryUser> getSortedUsers(Comparator<LibraryUser> comparator) {
        ArrayList<LibraryUser> list = new ArrayList<>(users.values());
        list.sort(comparator);
        return list;
    }

    public void addPublication(Publication publication) {
        if (publications.containsKey(publication.getTitle())) {
            throw new PublicationAlreadyExistsException(
                    "Publikacja o takim tytule już istnieje " + publication.getTitle()
            );
        }
        publications.put(publication.getTitle(), publication);
    }

    public void addUser(LibraryUser user) {
        if (users.containsKey(user.getPesel())) {
            throw new UserAlreadyExistsExceptions(
                    "Użytkownik ze wskazanym peselem już istnieje " + user.getPesel()
            );
        }
        users.put(user.getPesel(), user);
    }

    public boolean removePublication(String title) {
        if (publications.containsKey(title)) {
            publications.remove(title);
            return true;
        } else {
            return false;
        }
    }
}
