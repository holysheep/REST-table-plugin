jQuery.namespace("JIRA.Admin.Team.TeamRow");

JIRA.Admin.Team.TeamRow = AJS.RestfulTable.Row.extend({
    initialize: function () {
        AJS.RestfulTable.Row.prototype.initialize.apply(this, arguments);
        this.events["click .project-config-team-delete"] = "_delete";
        this.delegateEvents();
    },
    _delete: function (e) {
        if (!confirm('Delete the team?'))
            return;
        var row = this;
        this.model.destroy({
            data: this.model.toJSON(), success: function () {
                row.remove();
            }
        });
        e.preventDefault();
    },

    render: function () {
        var data = this.model.toJSON(),
            id = this.model.get("id"),
            $el = this.$el;
        $el.attr("id", "team-" + id + "-row").attr("data-id", id);
        $el.html(JIRA.Templates.Team.teamRow({
            team: data
        }));
        return this;
    }
});